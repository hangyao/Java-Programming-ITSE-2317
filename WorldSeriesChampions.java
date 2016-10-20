/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package worldserieschampions;
import java.io.*;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * This is a program for Assignment 7: World Series Champions of ITSE-2317
 * @author HangYao
 */
public class WorldSeriesChampions {
    public static int count = 0;
    public static String output = "";
    public static String input = "";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final String FILENAME = "WorldSeriesWinners.txt";
        ArrayList<String> data = new ArrayList<String>();
        
        // Read the data file
        int reply = JOptionPane.showConfirmDialog(null,
                "Do you want to use the default file " + FILENAME + "?",
                "Do you want to use the default file?",
                JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.NO_OPTION)
            System.exit(0);
        else {
            // Read the data from file.
            try {
                data = readData(FILENAME);
            } catch (IOException e) {
            }
        }
        
        // Sequential search the String array and print the result
        reply = JOptionPane.YES_OPTION;
        while (reply == JOptionPane.YES_OPTION) {
            count = 0;
            output = "";
            input = JOptionPane.showInputDialog(null, 
                   "What team do you want stats on?");
            if ((input != null) && (input.length() > 0)) {
                boolean found = sequentialSearch(data, input);
                if (found == true) {
                    JOptionPane.showMessageDialog(null, output);
                } else {
                    JOptionPane.showMessageDialog(null, 
                            "Can't find the team in the list.");
                }
            }
            reply = JOptionPane.showConfirmDialog(null,
                "Do you want to search for another team?",
                "Do you want to search for another team?",
                JOptionPane.YES_NO_OPTION);
        }
        System.exit(0);
    }
    
    /**
     * The readData method reads the data from a text file 'filename' and save 
     * Strings in an ArrayList.
     * @param filename The file name of the text file to be read.
     * @return The ArrayList contains all Strings from the text file.
     * @throws IOException 
     */
    public static ArrayList<String> readData(String filename) throws IOException {
        ArrayList<String> data = new ArrayList<String>();
        
        File file = new File(filename);
        Scanner inputFile = new Scanner(file);
        while (inputFile.hasNext()) {
            data.add(inputFile.nextLine());
        }
        inputFile.close();
        return data;
    }
    
    /**
     * The sequentialSearch method sequential search the String 'name' in the 
     * ArrayList 'array'.
     * @param array The ArrayList to search from.
     * @param name The String to search.
     * @return The boolean if String 'name' is found in ArrayList 'array'.
     */
    public static boolean sequentialSearch(ArrayList<String> array, String name) {
        final int STARTYEAR = 1903;
        int year;
        boolean found = false;
        for (int index = 0; index < array.size(); index++) {
            if (array.get(index).compareTo(name) == 0) {
                count ++;
                year = STARTYEAR + index;
                if ((year >= 1904) && (year < 1993))
                    year = year + 1;
                else if (year >= 1993)
                    year = year + 2;    
                output = output + Integer.toString(year) + ", ";  
                found = true;
            }
        }
        output = "The " + input + " have won the World Series in the years:\n" +
                output + "\nand won the World Series " + count + " times.";
        return found;
    }
    
}
