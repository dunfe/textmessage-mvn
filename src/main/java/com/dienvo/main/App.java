package com.dienvo.main;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

    private static List<String> dict; //the words exist in message
    private static List<String> prohibited; //the words can't use
    private static List<String> stringList; //file lines to list.
    private static List<Message> messageList = new ArrayList<>(); //list of message include time and message

    public static void main(String[] args) {
        String fileName = "textmsg.txt";
        readFile(fileName);
        checkFile();
        for (int i = 0; i < messageList.size(); i++) {
            checkMessage(messageList.get(i), i);
        }
    }

    public static void checkMessage(Message message, int i) {
        //if time of message no need to check
        if (checkTime(message)) {
            System.out.println("Message #" + (i + 1) + ": " + message.getContent().getContentOfMessage());
        } else {
            if (checkContent(message) && checkSpell(message) && checkProhibited(message)) {
                System.out.println("Message #" + (i + 1) + ": " + message.getContent().getContentOfMessage());
            } else
                System.out.println("Message #" + (i + 1) + ": FAILED TO SEND.");
        }
    }

    public static void readFile(String fileName){
        try {
            ClassLoader classLoader = ClassLoader.getSystemClassLoader();
            Path paths = Paths.get(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
            stringList = Files.readAllLines(paths);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    //read file
    public static void checkFile() {
        try {
            //read number of dictionary, prohibited and message
            List<String> itemNumber = stringList.stream()
                    .filter(line -> line.matches("\\d+"))
                    .collect(Collectors.toList());
            //get number of item of list
            int numberItemOfDict = Integer.parseInt(itemNumber.get(0));
            int numberItemOfProhibited = Integer.parseInt(itemNumber.get(1));
            int numberItemOfMessage = Integer.parseInt(itemNumber.get(2));

            //dictionary start from second line, limit by number of item dictionary
            dict = stringList.stream()
                    .skip(1)
                    .limit(numberItemOfDict)
                    .collect(Collectors.toList());
            //prohibited words start after sum of dictionary line and number of dict, prohibited words (2) limit by number of prohibited words
            prohibited = stringList.stream()
                    .skip(numberItemOfDict + 2)
                    .limit(numberItemOfProhibited)
                    .collect(Collectors.toList());
            //message start after dict and prohibited words. Increase by 2 (*2) because 2 line is one message.
            List<String> message = stringList.stream()
                    .skip(numberItemOfDict + numberItemOfProhibited + 3)
                    .limit(numberItemOfMessage * 2)
                    .collect(Collectors.toList());
            for (int i = 0; i < message.size(); i += 2) {
                String time = message.get(i);
                String content = message.get(i + 1);
                String[] arr = content.split(" ");
                String numberOfWords = arr[0];
                String[] arr2 = Arrays.copyOfRange(arr, 1, arr.length);
                String contentOfMessage = String.join(" ", arr2);
                Message mess = new Message(time, new Content(numberOfWords, contentOfMessage));
                messageList.add(mess);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //check time of message
    public static boolean checkTime(Message message) {
        DateTimeFormatter df = DateTimeFormat.forPattern("hh:mm a").withLocale(Locale.US);
        DateTime actual = df.parseLocalTime(message.getTime()).toDateTimeToday();
        DateTime limit1 = df.parseLocalTime("12:59 AM").toDateTimeToday();
        DateTime limit2 = df.parseLocalTime("6:59 AM").toDateTimeToday();
        //return true of message don't need to check
        //return false, so that message must check
        return actual.isBefore(limit1) || actual.isAfter(limit2);
    }

    //check message contain "i love you"
    public static boolean checkContent(Message message) {
        return !Pattern.compile(Pattern.quote("i love you"),
                Pattern.CASE_INSENSITIVE).matcher(message.getContent().getContentOfMessage()).find();
    }

    //check spell, if message have more than 3 words is misspelled return false
    public static boolean checkSpell(Message message) {
        String[] arr = message.getContent().getContentOfMessage().split(" ");
        int count = 0;
        String dictionary = String.join(" ", dict);
        for (String s : arr) {
            if (!Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(dictionary).find()) {
                count++;
            }
        }
        return count < 3;
    }

    //check message contain prohibited words
    public static boolean checkProhibited(Message message) {
        String contentOfMessage = message.getContent().getContentOfMessage();
        for (String s : prohibited) {
            if (Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(contentOfMessage).find()) {
                return false;
            }
        }
        return true;
    }
}
