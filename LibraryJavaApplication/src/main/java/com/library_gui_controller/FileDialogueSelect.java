package com.library_gui_controller;

import jakarta.activation.MimetypesFileTypeMap;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

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
    public static String copyImageToProject() throws IOException, IncorrectFileTypeException {
        File f = new File(openFileDialogue().toURI());
        String mimetype = new MimetypesFileTypeMap().getContentType(f);
        String type = mimetype.split("/")[0];
        if (type.equals("image")) {
            try{
                new File("src/main/resources/com/library_gui_controller/images/" + f.getName()).delete();
            }
            catch (Exception e){
                e.printStackTrace();
            }

            FileInputStream in = new FileInputStream(f);
            FileOutputStream out = new FileOutputStream("C:\\Users\\user\\Mahmoud\\GitHub Repos\\DBS_Project\\Library-Management-System\\LibraryJavaApplication\\src\\main\\resources\\com\\library_gui_controller\\images\\" + f.getName());
            BufferedInputStream bin = new BufferedInputStream(in);
            BufferedOutputStream bout = new BufferedOutputStream(out);
            int b = 0;
            while (b != -1) {
                b = bin.read();
                bout.write(b);
            }
            bin.close();
            bout.close();
        } else {
            throw new IncorrectFileTypeException("The File is not an image");
        }

        return f.getName();
    }


}
