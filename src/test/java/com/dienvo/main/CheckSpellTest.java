package com.dienvo.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckSpellTest {

    /*
     * ****************************************************************** *
     * This part follow part 1.6A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    //TC1: content is null
    @Test
    void checkSpell_for_TC1_eq() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkSpell(content));
    }

    //TC2: content is empty

    @Test
    void checkSpell_for_TC2_eq() {
        String content = "";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkSpell(content));
    }

    //TC3: content include misspell words
    @Test
    void checkSpell_for_TC3_eq() {
        String content = "love";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkSpell(content));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.7B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */

    //TC1: content = null
    @Test
    void checkSpell_for_TC1_bv() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkSpell(content));
    }

    //TC2: content = "ahole"

    @Test
    void checkSpell_for_TC2_bv() {
        String content = "love";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkSpell(content));
    }

    //TC3: content = "lve lve"
    @Test
    void checkSpell_for_TC3_bv() {
        String content = "lve lve";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkSpell(content));
    }

    //TC4: content = "aaholee"
    @Test
    void checkSpell_for_TC4_bv() {
        String content = "lve lve lve";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkSpell(content));
    }

    //TC4: content = "aaholee"
    @Test
    void checkSpell_for_TC5_bv() {
        String content = "lve lve lve lve";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkSpell(content));
    }



    /*
     * ******************************************************** *
     * This part follow part 1.7C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */

    //TC1: content = "love"

    @Test
    void checkSpell_for_TC1_sc() {
        String content = "love";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkSpell(content));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.7D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

    //TC1: content = "love"

    @Test
    void checkSpell_for_TC1_dc() {
        String content = "love";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertTrue(App.checkSpell(content));
    }

    //TC2: content = "lve lve lve"

    @Test
    void checkSpell_for_TC2_dc() {
        String content = "lve lve lve";
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertFalse(App.checkSpell(content));
    }

    //TC3: content is null
    @Test
    void checkSpell_for_TC3_dc() {
        String content = null;
        App.stringList = App.readFile("textmsg.txt");
        App.checkFile(App.stringList);
        assertThrows(IllegalArgumentException.class, ()-> App.checkSpell(content));
    }
}