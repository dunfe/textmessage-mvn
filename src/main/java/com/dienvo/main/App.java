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
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class App {

    public static List<String> dict; //the words exist in message
    public static List<String> prohibited; //the words can't use
    public static List<String> stringList; //file lines to list.
    public static List<Message> messageList = new ArrayList<>(); //list of message include time and message

    public static void main(String[] args) throws Exception {
        String fileName = "textmsg.txt";
        stringList = readFile(fileName);
        checkFile(stringList);
        for (int i = 0; i < messageList.size(); i++) {
            boolean time = checkTime(messageList.get(i).getTime());
            boolean content = checkContent(messageList.get(i).getContent().getContentOfMessage());
            boolean spell = checkSpell(messageList.get(i).getContent().getContentOfMessage());
            boolean prohibit = checkProhibited(messageList.get(i).getContent().getContentOfMessage());
            checkMessage(messageList.get(i), i, time, content, spell, prohibit);
        }
    }

    //read file to a list of lines
    public static List<String> readFile(String fileName) { //A
        List<String> temp = new ArrayList<>();
        if (fileName != null) { //B
            try { //C
                ClassLoader classLoader = ClassLoader.getSystemClassLoader(); //D
                Path paths = Paths.get(classLoader.getResource(fileName).getFile()); //E
                temp = Files.readAllLines(paths); //F
            } //G
            catch (Exception e) { //H
                throw new NullPointerException(); //I
            } //K
        } else throw new NullPointerException();//M
        return temp;
    }

    public static boolean checkMessage(Message message, int i, boolean time, boolean content, boolean spell, boolean prohibit) throws NullPointerException { //A
        //if time of message no need to check
        try {
            if (time) { //B
                System.out.println("Message #" + (i + 1) + ": " + message.getContent().getContentOfMessage()); //C
                return  true;
            } else { //D
                if (content && spell && prohibit) { //E
                    System.out.println("Message #" + (i + 1) + ": " + message.getContent().getContentOfMessage()); //F
                    return true;
                } else {//G
                    System.out.println("Message #" + (i + 1) + ": FAILED TO SEND."); //H
                    return false;
                } //I
            } //J
        } catch (NullPointerException e) {
            throw new NullPointerException();
        }
    }


    //check file and take content
    public static boolean checkFile(List<String> files) { //A
        try { //B
            //read number of dictionary, prohibited and message
            List<String> itemNumber = files.stream() //C
                    .filter(line -> line.matches("\\d+"))
                    .collect(Collectors.toList());
            //get number of item of list
            int numberItemOfDict = Integer.parseInt(itemNumber.get(0));
            int numberItemOfProhibited = Integer.parseInt(itemNumber.get(1));
            int numberItemOfMessage = Integer.parseInt(itemNumber.get(2));

            //dictionary start from second line, limit by number of item dictionary
            dict = files.stream()
                    .skip(1)
                    .limit(numberItemOfDict)
                    .collect(Collectors.toList());
            //prohibited words start after sum of dictionary line and number of dict, prohibited words (2) limit by number of prohibited words
            prohibited = files.stream()
                    .skip(numberItemOfDict + 2)
                    .limit(numberItemOfProhibited)
                    .collect(Collectors.toList());
            //message start after dict and prohibited words. Increase by 2 (*2) because 2 line is one message.
            List<String> message = files.stream()
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
            return true;
        } catch (Exception e) { //D
            e.printStackTrace(); //E
            return false;
        } //F
    }

    //check time of message
    public static boolean checkTime(String time) { //A
        try { //B
            DateTimeFormatter df = DateTimeFormat.forPattern("hh:mm a").withLocale(Locale.US); //C
            DateTime actual = df.parseLocalTime(time).toDateTimeToday();
            DateTime limit1 = df.parseLocalTime("12:59 AM").toDateTimeToday();
            DateTime limit2 = df.parseLocalTime("6:59 AM").toDateTimeToday();
            //return true of message don't need to check
            //return false, so that message must check
            if (actual.isBefore(limit1)) { //D
                return true; //E
            } else if (actual.isAfter(limit2)) { //F
                return true; //G
            }// H
        } catch (Exception e) { //I
            e.printStackTrace(); //J
        } //K
        return false; //M
    }

    //check message contain "i love you"
    public static boolean checkContent(String content) { //A
        return !Pattern.compile(Pattern.quote("i love you"),
                Pattern.CASE_INSENSITIVE).matcher(content).find(); //B
    }

    //check spell, if message have more than 3 words is misspelled return false
    public static boolean checkSpell(String content) { //A
        int count = 0; //B
        if (content != null && !content.equals("")) { //C
            String[] arr = content.split(" "); //D
            String dictionary = String.join(" ", dict);
            for (String s : arr) { //E
                if (!Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(dictionary).find()) { //F
                    count++; //G
                }// H
            } // I
        } else throw new IllegalArgumentException(); //J
        return count < 3; //K
    }

    //check message contain prohibited words
    public static boolean checkProhibited(String content) { //A
        if (content != null && !content.equals("")) { //B
            for (String s : prohibited) { //C
                if (Pattern.compile(Pattern.quote(s), Pattern.CASE_INSENSITIVE).matcher(content).find()) { //D
                    return false; //E
                } //F
            } // G
        } else throw new IllegalArgumentException(); //H
        return true; //I
    }
}
