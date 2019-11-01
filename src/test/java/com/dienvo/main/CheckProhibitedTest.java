package com.dienvo.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckProhibitedTest {

    /*
     * ****************************************************************** *
     * This part follow part 1.7A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    //TC1: content is null
    @Test
    void checkProhibited_for_TC1_eq() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkProhibited(content));
    }

    //TC2: content is empty

    @Test
    void checkProhibited_for_TC2_eq() {
        String content = "";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkProhibited(content));
    }

    //TC3: content include prohibited words
    @Test
    void checkProhibited_for_TC3_eq() {
        String content = "ahole";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkProhibited(content));
    }
    
    //TC4: content is not include prohibited words

    @Test
    void checkProhibited_for_TC4_eq() {
        String content = "haha";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkProhibited(content));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.7B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */

    //TC1: content = "aholee"
    @Test
    void checkProhibited_for_TC1_bv() {
        String content = "aholee";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkProhibited(content));
    }

    //TC2: content = "ahole"

    @Test
    void checkProhibited_for_TC2_bv() {
        String content = "ahole";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkProhibited(content));
    }

    //TC3: content = "aaholee"
    @Test
    void checkProhibited_for_TC3_bv() {
        String content = "aahole";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkProhibited(content));
    }




    /*
     * ******************************************************** *
     * This part follow part 1.7C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */

    //TC1: content = "ahole"

    @Test
    void checkProhibited_for_TC1_sc() {
        String content = "ahole";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkProhibited(content));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.7D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

    //TC1: content = "ahole"

    @Test
    void checkProhibited_for_TC1_dc() {
        String content = "haha";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkProhibited(content));
    }

    //TC2: content = "ahole"

    @Test
    void checkProhibited_for_TC2_dc() {
        String content = "ahole";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkProhibited(content));
    }

    //TC3: content is null
    @Test
    void checkProhibited_for_TC3_dc() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkProhibited(content));
    }
}