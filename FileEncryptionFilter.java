/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fileencryptionfilter;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * This is a program for Assignment 11: File Encryption Filter of ITSE-2317
 * @author HangYao
 */
public class FileEncryptionFilter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        final String INPUTFILENAME = "text.dat";
        final String OUTPUTFILENAME = "text_encryption.dat";
        List<String> data = new ArrayList<String>();
        String input = new String("");
        
        // Input data file
        int reply = JOptionPane.showConfirmDialog(null,
                "Do you want to use the default file " + INPUTFILENAME + "?",
                "Do you want to use the default file?",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.NO_OPTION) {
            input = JOptionPane.showInputDialog(null, 
                   "Enter the file name to be read:");
            try {
                data = readFile(input);
            } catch (IOException e) {
            }
        }
        else {
            try {
                data = readFile(INPUTFILENAME);
            } catch (IOException e) {
            }
        }
        
        // Encrypt the data
        JOptionPane.showMessageDialog(null, "Input file:\n\n" + data);
        List<String> encryption = encrypt(data);
        JOptionPane.showMessageDialog(null, "Encrypted file:\n\n" + encryption);
        
        // Output data file
        reply = JOptionPane.showConfirmDialog(null,
                "Do you want to output the file with default name " + OUTPUTFILENAME + "?",
                "Do you want to output the file with default name?",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.NO_OPTION) {
            input = JOptionPane.showInputDialog(null, 
                   "Enter the file name to be written:");
            try {
                writeFile(encryption, input);
            } catch (IOException e) {
            }
        }
        else {
            try {
                writeFile(encryption, OUTPUTFILENAME);
            } catch (IOException e) {
            }
        }
        System.exit(0);
    }
    
    /**
     * The readFile method read the data file to be encrypted.
     * @param filename The String of the file name to be read.
     * @return The List contains all Strings in the file.
     * @throws IOException 
     */
    public static List<String> readFile(String filename) 
            throws IOException {
        List<String> data = new ArrayList<String>();
        boolean endOfFile = false;
        try {
            DataInputStream inputFile = 
                new DataInputStream(new FileInputStream(filename));
            while (!endOfFile) {
                try {
                    data.add(inputFile.readUTF());
                } catch (EOFException e) {
                    endOfFile = true;
                }
            }
            JOptionPane.showMessageDialog(null, 
                "The file has been read successfully.");
            inputFile.close();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, 
                "The file is not found.");
        }
        return data;
    }
    
    /**
     * The writeFile method writes the List of encrypted Strings into a data file.
     * @param data The List of encrypted Strings.
     * @param filename The String of the file name to be written.
     * @throws IOException 
     */
    public static void writeFile(List<String> data, String filename) 
            throws IOException {
        DataOutputStream outputFile =
            new DataOutputStream(new FileOutputStream(filename));
        for (String element : data)
            outputFile.writeUTF(element);
        JOptionPane.showMessageDialog(null, 
            "The file has been written successfully.");
        outputFile.close(); 
    }
    
    /**
     * The encrypt method translates characters by adding 10 to the ascii values.
     * @param data The List of Strings to be encrypted.
     * @return The List of Strings been encrypted.
     */
    public static List<String> encrypt(List<String> data) {
        List<String> encryption = new ArrayList<String>();
        for (String element : data) {
            String strEncrypt = new String("");
            for (int i = 0; i < element.length(); i++) {
                int value = element.charAt(i);
                int charEncrypt;
                if (((value > 96) && (value < 113)) || ((value > 64) && (value < 81)))
                    charEncrypt = value + 10;
                else if (((value > 112) && (value < 123)) || ((value > 80) && (value < 91)))
                    charEncrypt = value - 16;
                else 
                    charEncrypt = value;
                strEncrypt += Character.toString((char) charEncrypt);
            }
            encryption.add(strEncrypt);
        }
        return encryption;
    }
}
