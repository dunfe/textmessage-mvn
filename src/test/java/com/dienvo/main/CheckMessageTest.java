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
        assertThrows(NullPointerException.class, ()-> App.checkMessage(message, i, true, true, true, true));
    }

    @Test
    void checkMessage_TC2_eq() {
        Message message = new Message("12:00 AM", new Content("3", "I lov you"));
        int i = 0;
        try {
            assertTrue(App.checkMessage(message, i, true, true, true, true));
        } catch (Exception e) {
            assertThrows(NullPointerException.class, ()-> App.checkMessage(message, i, true, true, true, true));
        }
    }

    @Test
    void checkMessage_TC3_eq() {
        Message message = new Message("12:00 AM", new Content("3", "I love you"));
        int i = 1;
        try {
            assertTrue(App.checkMessage(message, i, true, true, true, true));
        } catch (Exception e) {
            assertThrows(NullPointerException.class, ()-> App.checkMessage(message, i, true, true, true, true));
        }
    }
    @Test
    void checkMessage_TC4_eq() {
        Message message = new Message("12:00 AM", new Content("3", "I love you"));
        int i = 1;
        try {
            assertTrue(App.checkMessage(message, i, true, true, true, true));
        } catch (Exception e) {
            assertThrows(NullPointerException.class, ()-> App.checkMessage(message, i, true, true, true, true));
        }
    }

    /*
     * ******************************************************** *
     * This part follow part 1.2B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */


    /*
     * ******************************************************** *
     * This part follow part 1.2C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */


    /*
     * ******************************************************** *
     * This part follow part 1.2D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

}