/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piglatin;
import javax.swing.JOptionPane;

/**
 * This is a program for Assignment 9: Pig Latin of ITSE-2317
 * @author HangYao
 */
public class PigLatin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input = new String(""); // Hold and initialize input string
        
        while (input != null) {
            // Input a string.
            input = JOptionPane.showInputDialog(null,
                "Please enter a word or phrase to be translated into " +
                "Pig Latin.");
            if ((input != null) && (input.length() > 0)) {
                input = input.toUpperCase(); // Convert whole string to uppercase
                String[] words = input.split(" "); // Tokenize the string
                String output = new String(""); // Initialize output string
                for (String s : words) {
                    // Move the first letter to the end of word and append "AY"
                    String latin = s.substring(1) + s.substring(0, 1) + "AY ";
                    output += latin; 
                }
                // Print output string
                JOptionPane.showMessageDialog(null, 
                    "The phrase or word you entered is translated to: \n" +
                    output);
            } else {
                System.exit(0);
            }
        }
        System.exit(0);
    }
}
