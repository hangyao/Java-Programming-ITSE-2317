/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package internetserviceprovider;
import javax.swing.JOptionPane;

/**
 * This is a program for Assignment 3: Internet Service Provider of ITSE-2317
 * @author HangYao
 */
public class InternetServiceProvider {
    public static void main(String[] args) {
        String inputPackage; // To hold the package input
        String inputHours; // To hold the hours input
        double hours; // To hold the hours (double)
        double totalCharge; // To hold the total charge
        double chargeA; // To hold the charge of package A
        double chargeB; // To hold the charnge of package B
        double chargeC; // To hold the charge of packege C
        double saving = 0.0; // To hold the savings if switch to alternative package
        boolean altIsBetter = false; // To hold the flag if alternative package is better
        String alt = ""; // To hold the best alternative package 
        String altString = ""; // To hold the output string if any better alternative package
        String ifMore = "Y"; // To hold the flag if more bills to calculate
        
        // If ifMore flag is not "N", loop the program 
        while (!ifMore.equalsIgnoreCase("N")) {
            // Get the package
            inputPackage = JOptionPane.showInputDialog("Please enter the " +
                    "package (A/B/C):");
            // Convert to upper case
            inputPackage = inputPackage.toUpperCase();
            // Validate the package input
            if ((inputPackage == null) || 
                    !(inputPackage.equals("A") || inputPackage.equals("B") ||
                    inputPackage.equals("C"))) {
                JOptionPane.showMessageDialog(null, "The package must be" +
                        " A/B/C!");   
            } 
            else {
                // Get the hours
                inputHours = JOptionPane.showInputDialog("Please enter the " +
                        "number of hours:");
                hours = Double.parseDouble(inputHours);
                
                // Compute the charge of package A
                chargeA = hours <= 10 ? 9.95 : 
                        (9.95 + 2.00 * (hours - 10));
                // Compute the charge of package B
                chargeB = hours <= 20 ? 13.95 : 
                        (13.95 + 1.00 * (hours - 20));
                // Compute the charge of package C
                chargeC = 19.95;

                // Determine the package
                switch (inputPackage) {
                    case "A": // Case of package A
                        // If package B is the best
                        if (chargeB < chargeA && chargeB <= chargeC) {
                            altIsBetter = true;
                            alt = "B";
                            saving = chargeA - chargeB;
                        }
                        // If package C is the best
                        else if (chargeC < chargeA && chargeC < chargeB) {
                            altIsBetter = true;
                            alt = "C";
                            saving = chargeA - chargeC;
                        }
                        // If package A is the best
                        else 
                            altIsBetter = false;
                        totalCharge = chargeA;
                        break;
                    case "B": // Case of package B
                        // If package C is better
                        if (chargeC < chargeB) {
                            altIsBetter = true;
                            alt = "C";
                            saving = chargeB - chargeC;
                        }
                        // If package B is better
                        else 
                            altIsBetter = false;
                        totalCharge = chargeB;
                        break;
                    case "C": // Case of package C
                        chargeC = 19.95;
                        altIsBetter = false;
                        totalCharge = chargeC;
                        break;
                    default: // Set default values
                        altIsBetter = false;
                        alt = "";
                        saving = 0.0;
                        totalCharge = chargeC;
                }
                // If any better package exists, construct the output string
                if (altIsBetter)
                    altString = "\nIf the customer switched to package " + alt +
                            ", the savings would be $" + 
                            String.format("%.2f.", saving);
                else
                    altString = "";

                // Display the output message dialog
                JOptionPane.showMessageDialog(null, "The monthly bill for " + 
                        "the customer using package " + 
                        inputPackage + " is $" + 
                        String.format("%.2f.", totalCharge) + altString);
                // Ask if more input needed
                ifMore = JOptionPane.showInputDialog("Are there more monthly" +
                        " bills to calculate? Y/N");
            }    
        }
        System.exit(0);
    }
}
