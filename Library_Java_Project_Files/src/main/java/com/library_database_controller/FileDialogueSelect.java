package com.library_database_controller;

import java.io.IOException;
import java.io.*;
import java.util.*;
import javax.swing.*;

public class FileDialogueSelect {
    public static File openFileDialogue() throws IOException{
        JFileChooser chooser = new JFileChooser();
        Scanner in = null;
        File selected = null;
        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
             selected = chooser.getSelectedFile();
        }
        return selected;

    }
//    public static void main(String args []) throws IOException {
//        openFileDialogue();
//    }
}