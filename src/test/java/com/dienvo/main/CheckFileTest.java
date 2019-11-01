package com.dienvo.main;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CheckFileTest {

    /*
     * ****************************************************************** *
     * This part follow part 1.3A  document.                              *
     * Using equivalence partitioning technique                           *
     * ****************************************************************** *
     */

    //TC1: files is null
    @Test
    void checkFile_for_TC1_eq() {
        List<String> files = null;
        assertThrows(NullPointerException.class, ()-> App.checkFile(files));
    }

    @Test
    void checkFile_for_TC2_eq() {
        List<String> files = new ArrayList<>();
        assertThrows(NullPointerException.class, ()-> App.checkFile(files));
    }

    @Test
    void checkFile_for_TC3_eq() {
        List<String> files = App.readFile("textmsg.txt");
        assertThrows(NullPointerException.class, ()-> App.checkFile(files));
    }

    /*
     * ******************************************************** *
     * This part follow part 1.3B in unit test document.        *
     * Using boundary value technique                           *
     * ******************************************************** *
     */


    /*
     * ******************************************************** *
     * This part follow part 1.3C in unit test document.        *
     * Using Statement coverage                                 *
     * ******************************************************** *
     */


    /*
     * ******************************************************** *
     * This part follow part 1.3D in unit test document.        *
     * Using Decision  coverage                                 *
     * ******************************************************** *
     */
}