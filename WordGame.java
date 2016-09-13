/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wordgame;
import javax.swing.JOptionPane;

/**
 * This program is for Assignment 2 - Word Game of Java Programming ITSE-2317 
 * @author HangYao
 */
public class WordGame {
    public static void main(String[] args) {
        String name; // His or her name
        String age; // His or her age
        String city; // The name of a city
        String college; // The name of a college
        String profession; // A profession
        String animal; // A type of animal
        String petName; // A pet's name
        
        // Enter the name
        name = JOptionPane.showInputDialog("Enter the name:");
        
        // Enter the age
        age = JOptionPane.showInputDialog("Enter the age:");
        
        // Enter the name of a city
        city = JOptionPane.showInputDialog("Enter the name of a city:");
        
        // Enter the name of a college
        college = JOptionPane.showInputDialog("Enter the name of a college:");
        
        // Enter the profession
        profession = JOptionPane.showInputDialog("Enter the profession:");
        
        // Enter a type of animal
        animal = JOptionPane.showInputDialog("Enter a type of animal:");
        
        // Enter a pet's name
        petName = JOptionPane.showInputDialog("Enter a pet's name:");
        
        // Display the story
        JOptionPane.showMessageDialog(null, "There once was a person names " + 
                name + " who lived in " + city + ".\nAt the age of " + 
                age + ", " + name + " went to college at " + college + ".\n" +
                name + " graduated and went to work as a(n) " + profession + 
                ".\nThen " + name+ " adopted a(n) " + animal + " named " + 
                petName + ".\nThey both lived happliy ever after.");
        System.exit(0);
    }
}
