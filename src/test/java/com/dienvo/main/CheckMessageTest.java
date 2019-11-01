package com.dienvo.main;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckMessageTest {

    /*
     * ****************************************************************** *
     * This part follow part 1.2A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    @Test
    void checkMessage_TC1_eq() {
        Message message = null;
        int i = 0;
        assertThrows(NullPointerException.class, () -> App.checkMessage(message, i, true, true, true, true));
    }

    @Test
    void checkMessage_TC2_eq() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 0;
        assertTrue(App.checkMessage(message, i, true, true, true, true));
    }

    @Test
    void checkMessage_TC3_eq() {
        Message message = new Message("12:00 AM", new Content("3", "I love you"));
        int i = 1;
        assertTrue(App.checkMessage(message, i, true, true, true, true));
    }

    @Test
    void checkMessage_TC4_eq() {
        Message message = new Message("12:00 AM", new Content("3", "I love you"));
        int i = -11;
        assertThrows(IllegalArgumentException.class, () -> App.checkMessage(message, i, true, true, true, true));
    }

    /*
     * ******************************************************** *
     * This part follow part 1.2B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */

    //TC1: i < 0
    @Test
    void checkMessage_TC1_bv() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = -1;
        assertThrows(IllegalArgumentException.class, () -> App.checkMessage(message, i, true, true, true, true));
    }

    //TC2: i = 0
    @Test
    void checkMessage_TC2_bv() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 0;
        assertTrue(App.checkMessage(message, i, true, true, true, true));
    }

    //TC3: i > 0
    @Test
    void checkMessage_TC3_bv() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 1;
        assertTrue(App.checkMessage(message, i, true, true, true, true));
    }


    /*
     * ******************************************************** *
     * This part follow part 1.2C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */

    //TC1: message is valid i = 0 true
    @Test
    void checkMessage_TC1_sc() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 0;
        assertTrue(App.checkMessage(message, i, true, true, true, true));
    }



    /*
     * ******************************************************** *
     * This part follow part 1.2D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

    //TC1: message is valid i = 0 true
    @Test
    void checkMessage_TC1_dc() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 0;
        assertTrue(App.checkMessage(message, i, true, true, true, true));
    }


    //TC2: time is false
    @Test
    void checkMessage_TC2_dc() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 0;
        assertTrue(App.checkMessage(message, i, false, true, true, true));
    }

    //TC3: other is false
    @Test
    void checkMessage_TC3_dc() {
        Message message = new Message("12:00 AM", new Content("3", "I love you"));
        int i = 0;
        assertFalse(App.checkMessage(message, i, false, false, false, false));
    }

}