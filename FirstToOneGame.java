package firsttoonegame;
import javax.swing.JOptionPane;

/**
   This program demonstrates a solution to the
   First to One Game programming challenge.
 */
public class FirstToOneGame {
   public static void main(String[] args) {
      final int NUM_SIDES = 6;         // Number of sides on the die
      final int STARTING_POINTS = 50;  // Number of starting points
      String player1Name;              // First player's name
      String player2Name;              // Second player's name
      int round = 0;                   // Number of rounds
      int roll1 = 0, roll2 = 0;        // Rolls of players

      // Create the die.
      Die die = new Die(NUM_SIDES);
      // Get the player's names.
      player1Name = JOptionPane.showInputDialog(null, 
                   "Enter the first player's name: ");
      player2Name = JOptionPane.showInputDialog(null, 
                   "Enter the second player's name: ");
      // Create the two players.
      Player player1 = new Player(player1Name, STARTING_POINTS);
      Player player2 = new Player(player2Name, STARTING_POINTS);
      // Play the game until one of the player's wins.
      while (gameInPlay(player1, player2)) {
         // Update the number of rounds.
         round ++;
         // If the game is still being played,
         // Player 1 rolls the die and takes the first turn.
         // Player 2 rolls the die and takes a turn.
         if (gameInPlay(player1, player2)) {
            roll1 = takeTurn(player1, die);
            roll2 = takeTurn(player2, die);
         }
         // Display the result of this round
         JOptionPane.showMessageDialog(null, 
                 "Round: " + round + 
                 "\n\n" + player1Name + " rolled a " + roll1 +
                 "\n\n" + player2Name + " rolled a " + roll2 +
                 "\n\n" + player1Name + ": " + player1.getPoints() +
                 "\n\n" + player2Name + ": " + player2.getPoints());
      }
      // Display the name of the winning player.
      determineWinner(player1, player2);
      System.exit(0);
   }

   /**
      The gameInPlay method determines if the game
      is still in play. The method returns true
      if the game is still being played, or false if
      one of the players has won the game.
      @param p1 A reference to the Player object
             for player 1.
      @param p2 A reference to the Player object
             for player 2.
      @return True if the game is still being played.
    */
   public static boolean gameInPlay(Player p1, Player p2) {
      boolean status = false; // Set the flag to false.
      // Determine if the game is still being played.
      if (p1.getPoints() != 1 && p2.getPoints() != 1) {
         status = true; // Set the flag to true.
      }
      // Return the status.
      return status;
   }

   /**
      The takeTurn method simulates a player's turn.
      @param p A reference to a Player object.
      @param d A reference to a Die object.
      @return The roll of the player.
    */
   public static int takeTurn(Player p, Die d) {
      d.roll();   // Roll the die.
      // Determine if the player's points are less than the
      // number of points needed to win.
      if (p.getPoints() - d.getValue() < 1) {
         // If so, add the value to the player's points.
         p.setPoints(p.getPoints() + d.getValue());
      }
      else {
         // Subtract the value from the player's points.
         p.setPoints(p.getPoints() - d.getValue());
      }
      return d.getValue();
   }

   /**
      The determineWinner method displays the winner
      of the game.
      @param p1 A reference to the Player object
             for player 1.
      @param p2 A reference to the Player object
             for player 2.
    */
   public static void determineWinner(Player p1, Player p2) {
      // Determine if player 1 has won the game.
      if (p1.getPoints() == 1) {
         // If so, display a message declaring player 1
         // as the winner.
         JOptionPane.showMessageDialog(null, 
                 p1.getName() + " is the winner!");
      }
      else {
         // Display a message declaring player 2 as the winner.
         JOptionPane.showMessageDialog(null, 
                 p2.getName() + " is the winner!");
      }
   }
}