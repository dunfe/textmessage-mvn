package com.dienvo.main;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadFileTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    /**
     * ****************************************************************** *
     * This part follow part 1.1A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    //TC1: fileName == null
    @Test
    void readFile_throw_NullPointerException_for_null_fileName() {
        String fileName = null;
        assertThrows(NullPointerException.class,() -> {
            App.readFile(fileName);
        });
    }

    //TC2: fileName != null
    @Test
    void readFile_throw_NullPointerException_for_invalid_fileName() {
        String fileName = "%$#%";
        assertThrows(NullPointerException.class, ()-> App.readFile(fileName));
    }
    //TC3: fileName == "textmsg.txt"
    @Test
    void readFile_done_for_valid_fileName() {
        String fileName = "textmsg.txt";
        App.readFile(fileName);
        assertTrue(App.stringList.size() > 0);
    }
    /*
     * ******************************************************** *
     * This part follow part 1.1B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */

    //TC1: fileName = "ttextmsg.txt"
    @Test
    void readFile_throw_NullPointerException_for_TC1_of_boundary_values() {
        String fileName = "ttextmsg.txt";
        assertThrows(NullPointerException.class, ()-> App.readFile(fileName));
    }
    //TC2: fileName = "textmsg.txt"
    @Test
    void readFile_done_for_TC2_of_boundary_values() {
        String fileName = "textmsg.txt";
        App.readFile(fileName);
        assertTrue(App.stringList.size() > 0);
    }

    //TC3: fileName = "textmsg.txtt"
    @Test
    void readFile_throw_NullPointerException_for_TC3_of_boundary_values() {
        String fileName = "textmsg.txtt";
        assertThrows(NullPointerException.class, ()-> App.readFile(fileName));
    }

    /*
     * ******************************************************** *
     * This part follow part 1.1C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */

    //TC2: fileName = "textmsg.txt"
    @Test
    void readFile_done_for_TC1_of_statement_coverage() {
        String fileName = "textmsg.txt";
        App.readFile(fileName);
        assertTrue(App.stringList.size() > 0);
    }

    /*
     * ******************************************************** *
     * This part follow part 1.1D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */

    //TC1: fileName = null
    @Test
    void readFile_thow_NullPointerException_for_TC1_of_decision_covrage() {
        String fileName = null;
        assertThrows(NullPointerException.class, ()-> App.readFile(fileName));
    }

    //TC2: fileName = "textmsg.txt"
    @Test
    void readFile_done_for_TC2_of_decision_covrage() {
        String fileName = "textmsg.txt";
        App.readFile(fileName);
        assertTrue(App.stringList.size() > 0);
    }
    //TC3: fileName = "#$%"
    @Test
    void readFile_thow_NullPointerException_for_TC3_of_decision_covrage() {
        String fileName = "#$%";
        assertThrows(NullPointerException.class, ()-> App.readFile(fileName));
    }
}