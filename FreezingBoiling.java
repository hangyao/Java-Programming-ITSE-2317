/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package freezingboiling;
import javax.swing.JOptionPane;

/**
 * This is a program for Assignment 6: Freezing and Boiling Points of ITSE-2317
 * @author HangYao
 */
public class FreezingBoiling {
    private int freezing;
    private int boiling;
    
    /**
     * Constructor.
     * @param fre the value of freezing point
     * @param boi the value of boiling point
     */
    public FreezingBoiling(int fre, int boi) {
        freezing = fre;
        boiling = boi;
    }
    
    /**
     * The setFreezing method stores a value in the freezing field.
     * @param fre the value of freezing point
     */
    public void setFreezing(int fre) {
        freezing = fre;
    }
    
    /**
     * The setBoiling method stores a value in the boiling field.
     * @param boi the value of boiling point
     */
    public void setBoiling(int boi) {
        boiling = boi;
    }
    
    /**
     * The getFreezing method returns a FreezingBoiling object's freezing field.
     * @return the value in the freezing field
     */
    public int getFreezing() {
        return freezing;
    }
    
    /**
     * The getBoiling method returns a FreezingBoiling object's boiling field.
     * @return the value in the boiling field
     */
    public int getBoiling() {
        return boiling;
    }
    
    /**
     * The getState method returns a FreezingBoiling object's state.
     * @param temp the value of temperature 
     * @return a String of the state: "Solid", "Liquid", or "Gas"
     */
    public String getState(int temp) {
        if (temp < freezing)
            return "Solid";
        else if (temp < boiling)
            return "Liquid";
        else
            return "Gas";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String input; // To hold user input string
        
        // Create FreezingBoiling objects for different matters
        FreezingBoiling ethyl = new FreezingBoiling(-173, 172);
        FreezingBoiling mercury = new FreezingBoiling(-38, 676);
        FreezingBoiling oxygen = new FreezingBoiling(-362, -306);
        FreezingBoiling water = new FreezingBoiling(32, 212);
        
        // Display the entry message
        JOptionPane.showMessageDialog(null, "Different substances exist in " +
                "different states of matter depending on the temperature.\n" +
                "This program displays the states of matter for some common" +
                " substances based on a \ntemperature entered by the user.");
        // Input the temperature value
        input = JOptionPane.showInputDialog("Please enter a temperature.");
        // Looping structure to enter the temperature
        while (input != null) {
            try {
                // Only proceed if the input is an integer 
                int temp = Integer.parseInt(input);
                // Check if the input is above the absolute zero
                if (temp <= -460) {
                    JOptionPane.showMessageDialog(null, 
                            "Temperature must be higher than -460 degrees Farenheit.");
                    input = JOptionPane.showInputDialog("Please enter a temperature.");
                } else {
                    // Get states of matters under the input temperature
                    String stateEthyl = ethyl.getState(temp);
                    String stateMercury = mercury.getState(temp);
                    String stateOxygen = oxygen.getState(temp);
                    String stateWater = water.getState(temp);
                    // Construct the output String
                    String result = "<html><table><tr><td align='center' colspan='2'>" + 
                            "Common States of Matter" + "<br>" + input + 
                            " Degrees Farenheit" + "<br>" + "---------------------" 
                            + "</td></tr>" + "<tr><td>" + 
                            "Ethyl Alcohol" + "</td><td align='right'>" +
                            stateEthyl + "</td></tr>" + "<tr><td>" + 
                            "Mercury" + "</td><td align='right'>" +
                            stateMercury + "</td></tr>" + "<tr><td>" + 
                            "Oxygen" + "</td><td align='right'>" + 
                            stateOxygen + "</td></tr>" + "<tr><td>" + 
                            "Water" + "</td><td align='right'>" +
                            stateWater + "</td></tr></table></html>";
                    // Display the result
                    JOptionPane.showMessageDialog(null, result);
                    input = JOptionPane.showInputDialog("Please enter a temperature.");
                }
            } catch(NumberFormatException e) {
                // Re-enter the input value if it is not an integer
                JOptionPane.showMessageDialog(null, "Value must be an integer.");
                input = JOptionPane.showInputDialog("Please enter a temperature.");
            }
        }
        // Shut down the program if cancel the input dialog
        JOptionPane.showMessageDialog(null, "The program is shutting down.");
        System.exit(0);
    }
}