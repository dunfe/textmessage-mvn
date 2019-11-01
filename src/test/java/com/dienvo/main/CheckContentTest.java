package com.dienvo.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckContentTest {

    /*
     * ****************************************************************** *
     * This part follow part 1.5A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    //TC1: content is null
    @Test
    void checkContent_for_TC1_eq() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()-> App.checkContent(content));
    }

    //TC2: content is empty

    @Test
    void checkContent_for_TC2_eq() {
        String content = "";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkContent(content));
    }

    //TC3: content include "i love you"
    @Test
    void checkContent_for_TC3_eq() {
        String content = "i love you";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkContent(content));
    }

    //TC4: content is not include "i love you"
    @Test
    void checkContent_for_TC4_eq() {
        String content = "i lov ou";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkContent(content));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.5B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */

    //TC1: content = null
    @Test
    void checkContent_for_TC1_bv() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()-> App.checkContent(content));
    }

    //TC2: content = "i love youu"

    @Test
    void checkContent_for_TC2_bv() {
        String content = "i love youu";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkContent(content));
    }

    //TC3: content = "i love you"
    @Test
    void checkContent_for_TC3_bv() {
        String content = "i love you";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkContent(content));
    }

    //TC4: content = "i love yo"
    @Test
    void checkContent_for_TC4_bv() {
        String content = "i love yo";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkContent(content));
    }

    //TC5: content = ""
    @Test
    void checkContent_for_TC5_bv() {
        String content = "";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkContent(content));
    }



    /*
     * ******************************************************** *
     * This part follow part 1.5C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */

    //TC1: content = "haha"

    @Test
    void checkContent_for_TC1_sc() {
        String content = "haha";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkContent(content));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.5D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

    //TC1: content = "love"

    @Test
    void checkContent_for_TC1_dc() {
        String content = "love";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkContent(content));
    }

    //TC2: content = "lve lve lve"

    @Test
    void checkContent_for_TC2_dc() {
        String content = "i love you";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkContent(content));
    }

    //TC3: content is null
    @Test
    void checkContent_for_TC3_dc() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(NullPointerException.class, ()-> App.checkContent(content));
    }
}