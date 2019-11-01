package com.dienvo.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckTimeTest {

    /*
     * ****************************************************************** *
     * This part follow part 1.4A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    //TC1: time is null
    @Test
    void checkTime_for_TC1_eq() {
        String time = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()-> App.checkTime(time));
    }

    //TC2: time is empty

    @Test
    void checkTime_for_TC2_eq() {
        String time = "";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()-> App.checkTime(time));
    }

    //TC3: time = "as:dg 12”
    @Test
    void checkTime_for_TC3_eq() {
        String time = "as:dg 12";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()->App.checkTime(time));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.4B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */

    //TC1: time = "12:58 AM"
    @Test
    void checkTime_for_TC1_bv() {
        String time = "12:58 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkTime(time));
    }

    //TC2: time = "12:59 AM"

    @Test
    void checkTime_for_TC2_bv() {
        String time = "12:59 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkTime(time));
    }

    //TC3: time = "1:00 AM"
    @Test
    void checkTime_for_TC3_bv() {
        String time = "1:00 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkTime(time));
    }

    //TC4: time = "6:58 AM"
    @Test
    void checkTime_for_TC4_bv() {
        String time = "6:58 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkTime(time));
    }

    //TC5: time = "6:59 AM"
    @Test
    void checkTime_for_TC5_bv() {
        String time = "6:58 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkTime(time));
    }

    //TC6: time = "7:00 AM"
    @Test
    void checkTime_for_TC6_bv() {
        String time = "7:00 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkTime(time));
    }



    /*
     * ******************************************************** *
     * This part follow part 1.4C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */

    //TC1: time = "12:00 AM"

    @Test
    void checkTime_for_TC1_sc() {
        String time = "12:00 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkTime(time));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.4D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

    //TC1: time = "12:00 AM"

    @Test
    void checkTime_for_TC1_dc() {
        String time = "12:00 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkTime(time));
    }

    //TC2: time = "1:00 AM"

    @Test
    void checkTime_for_TC2_dc() {
        String time = "1:00 AM";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkTime(time));
    }

    //TC3: time is null
    @Test
    void checkTime_for_TC3_dc() {
        String time = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()-> App.checkTime(time));
    }
}