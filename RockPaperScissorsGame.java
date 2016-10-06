/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rockpaperscissorsgame;
import javax.swing.JOptionPane;
import java.util.Random;

/**
 * This is a program for Assignment 5: Rock, Paper, Scissors Game of ITSE-2317
 * @author HangYao
 */
public class RockPaperScissorsGame {
    public static int wonGame = 0; // To hold the total number of won games
    public static int lostGame = 0; // To hold the total number of lost games
    public static int tiedGame = 0; // To hold the total number of tied games

    /**
     * 
     * @param args 
     */
    public static void main(String[] args) {
        String moreGame = "Y"; // To hold the flag if play game again
        
        // If moreGame flag is not "N", loop the program 
        while (!moreGame.equalsIgnoreCase("N")) {
            int computerHand = getComputerHand(); // Get computer's choice
            int userHand = getUserHand(); // Get user's choice
            compareHands(computerHand, userHand); // Compare to get the result
            String output = "Your Wins: " + wonGame + "\nComputer Wins: " +
                    lostGame + "\nTied Game: " + tiedGame; // Create output strings
            moreGame = JOptionPane.showInputDialog(output + 
                    "\n\nWould you like" + " to play again?\n" + 
                    "(Type Y for Yes or N for No)"); // Output and play more games
        }
        System.exit(0);
    }
    
    /**
     * This method generates a random number and use it as the computer's choice.
     * @return value, 1 = rock, 2 = paper, 3 = scissors
     */
    public static int getComputerHand() {
        Random randomNumbers = new Random();
        int value = randomNumbers.nextInt(3) + 1;
        return value;
    }
    
    /**
     * This method get the user's choice from an option dialog.
     * @return value, 1 = rock, 2 = paper, 3 = scissors
     */
    public static int getUserHand() {
        Object[] options = {"Rock", "Paper", "Scissors"};
        int value = JOptionPane.showOptionDialog(null,
                "Please choose Rock, Paper, or Scissors:", 
                "Input",
                JOptionPane.YES_NO_CANCEL_OPTION, 
                JOptionPane.DEFAULT_OPTION,
                null,
                options,
                options[0]);
        return value + 1;
    }
    
    /**
     * This method compares the computer's choice against the user's choice, and 
     * shows the result of the game in message dialogs. The counts of games are 
     * saved to public variables. If the game is tied, a recursion is applied to
     * call this method itself to play the game again.
     * @param computerHand is the computer's choice:
     *                     1 = rock, 2 = paper, 3 = scissors
     * @param userHand is the user's choice
     *                 1 = rock, 2 = paper, 3 = scissors
     */
    public static void compareHands(int computerHand, int userHand) {
        int result = computerHand - userHand;
        switch (result) {
            case 1: // Computer won
            case -2: // Computer won
                showComputerHand(computerHand);
                JOptionPane.showMessageDialog(null, "You lost!");
                lostGame += 1;
                break;
            case -1: // User won
            case 2: // User won
                showComputerHand(computerHand);
                JOptionPane.showMessageDialog(null, "You won!");
                wonGame += 1;
                break;
            case 0:
                showComputerHand(computerHand);
                JOptionPane.showMessageDialog(null, "You have a tied game!");
                tiedGame += 1;
                computerHand = getComputerHand();
                userHand = getUserHand();
                compareHands(computerHand, userHand); // Recursion
                break;
        }
    }
    
    /**
     * This method is to display the computer's choice.
     * @param computerHand is the computer's choice:
     *                     1 = rock, 2 = paper, 3 = scissors
     */
    public static void showComputerHand(int computerHand){
        String computerHandString = "";
        switch (computerHand) {
            case 1:
                computerHandString = "rock";
                break;
            case 2:
                computerHandString = "paper";
                break;
            case 3:
                computerHandString = "scissors";
                break;
        }
        JOptionPane.showMessageDialog(null, "The computer chose " + 
                computerHandString + "!"); 
    }
}
