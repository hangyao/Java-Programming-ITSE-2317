/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hoteloccupancy;
import javax.swing.JOptionPane;

/**
 * This is a program for Assignment 4: Hotel Occupancy of ITSE-2317
 * @author HangYao
 */
public class HotelOccupancy {
    public static void main(String[] args) {
        final int MIN_FLOORS = 1; // Minimum number of floors = 1
        final int MIN_ROOMS = 10; // Minimum number of rooms per floor = 10
        final int SKIP_FLOOR = 13; // Skipped floor = 13
        int totalFloors = 0; // To hold the number of floors in the hotel
        int totalRooms = 0; // To hold the total number of rooms
        int totalOccupied = 0; // To hold the total number of occupied rooms
        int totalVacant; // To hold the total number of vacant rooms
        int numRooms = 0; // To hold the number of rooms per floor
        int numOccupied = 9999; // To hold number of occupied rooms per floor
        double occupancyRate; // To hold the occupancy rate
        String input; // To hold user input strings
        
        // Get the total number of floors in the hotel
        input = JOptionPane.showInputDialog("Enter the number of floors " +
                "in the hotel.");
        if (input != null) {
            try {
                totalFloors = Integer.parseInt(input);
            } catch(NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Value must be an integer!");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "User cancelled the program!");
            System.exit(0);
        }
            
        
        // Validate the number of floors no less than the minimum number
        while (totalFloors < MIN_FLOORS) {
            input = JOptionPane.showInputDialog("The number must be at least " +
                    MIN_FLOORS + ".\nEnter the number of floors in the hotel.");
            if (input != null) {
                try {
                    totalFloors = Integer.parseInt(input);
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Value must be an integer!");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "User cancelled the program!");
                System.exit(0);
            }
        }
        
        // Loop over the total number of floors
        for (int floor = 1; floor <= totalFloors; floor++) {
            // Skip the 13th floor
            if (floor == SKIP_FLOOR)
                continue;
            
            // Get the number of rooms on each floor
            input = JOptionPane.showInputDialog("Enter the number of rooms " +
                    "on floor " + floor + " of the hotel.");
            if (input != null) {
                try {
                    numRooms = Integer.parseInt(input);
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Value must be an integer!");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "User cancelled the program!");
                System.exit(0);
            }
            
            // Validate the number of rooms no less than the minimum number
            while (numRooms < MIN_ROOMS) {
                input = JOptionPane.showInputDialog("The number must be " + 
                        "at least " + MIN_ROOMS + ".\nEnter the number of " +
                        "rooms on floor " + floor + " of the hotel.");
                if (input != null) {
                    try {
                        numRooms = Integer.parseInt(input);
                    } catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Value must be an integer!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "User cancelled the program!");
                    System.exit(0);
                }
            }
            
            // Get the number of occupied rooms on each floor
            input = JOptionPane.showInputDialog("Enter the number of rooms " + 
                    "on floor " + floor + " that are occupied.");
            if (input != null) {
                try {
                    numOccupied = Integer.parseInt(input);
                } catch(NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Value must be an integer!");
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "User cancelled the program!");
                System.exit(0);
            }
            
            // Validate the number of occupied rooms no more than the number of rooms.
            while (numOccupied > numRooms) {
                input = JOptionPane.showInputDialog("The number must be " + 
                        "less than " + numRooms + ".\nEnter the number of " +
                        "rooms on floor " + floor + " that are occupied.");
                if (input != null) {
                    try {
                        numOccupied = Integer.parseInt(input);
                    } catch(NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Value must be an integer!");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "User cancelled the program!");
                    System.exit(0);
                }
            }
            
            // Calculate cumulateive sum for total rooms and total occupied rooms
            totalRooms += numRooms;
            totalOccupied += numOccupied;   
        }
        // Calculate total vacant rooms and occupancy rate
        totalVacant = totalRooms - totalOccupied;
        occupancyRate = (double) totalOccupied / (double) totalRooms * 100.0;
            
        // Display the results
        JOptionPane.showMessageDialog(null, "There are a total of " + 
                totalRooms + " rooms in the hotel.\nThere are a total of " + 
                totalOccupied + " rooms that are occupied.\nThe number of " +
                "rooms that are vacant is " + totalVacant + 
                ".\nThe occupancy rate is " + 
                String.format("%.2f", occupancyRate) + "%.");
        
        System.exit(0);
    }
}
