package firsttoonegame;
/**
   The Player class simulates a player in the
   First to One Game.
 */
 
public class Player
{
   // Fields
   private String name; // The player's name
   private int points;  // The player's points
   
   /**
      The constructor accepts two arguments for
      the player's name and points.
      @param n The player's name.
      @param p The player's points.
    */
       
   Player (String n, int p)
   {
      name = n;
      points = p;
   }
   
   /**
      The getName method returns 
      the name of the player.
      @return The name of the player.
    */
    
   public String getName()
   {
      return name;
   }
   
   /**
      The getPoints method returns 
      the number of points.
      @return The player's points.
    */
    
   public int getPoints()
   {
      return points;
   }
   
   /**
      The setName method accepts an 
      argument for the name of the player.
      @param n The player's name.
    */
    
   public void setName(String n)
   {
      name = n;
   }
   
   /**
      The setPoints method accepts an 
      argument for the player's points.
      @param p The player's points.
    */
    
   public void setPoints(int p)
   {
      points = p;
   }
}