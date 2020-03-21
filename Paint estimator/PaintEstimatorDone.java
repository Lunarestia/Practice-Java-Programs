import java.util.Scanner;
import java.lang.Math; 
// Note: Needed for math functions in part (3)

public class PaintEstimator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double wallHeight = 0.0;
      double wallWidth = 0.0;
      double wallArea = 0.0;
      final double gallonCovers = 400; //1 gallon covers approximately 400 sq. ft.
      double gallonsPerCan = 1.0;
      double paintNeeded = 0.0;
      
      //Prompt to enter wall height
      System.out.println("Enter wall height (feet): ");
      wallHeight = scnr.nextDouble();
      
      //Prompt to enter wall width
      System.out.println("Enter wall width (feet) ");
      wallWidth = scnr.nextDouble();
      
      // Calculate and output wall area
      wallArea = wallHeight * wallWidth;                        
      System.out.println("Wall area: " + wallArea + " square feet.");    
      
      //Calculate and output the amount of paint in gallons needed to paint the wall
      paintNeeded = wallArea / gallonCovers;
      System.out.println("Paint needed: " + paintNeeded + " gallons.");
      
      //Calculate and output the number of 1 gallon cans needed to paint the wall, rounded up to nearest integer
      double gallonsNeeded = paintNeeded / gallonsPerCan;
      System.out.println("Number of cans needed: "+ gallonsNeeded+" can(s)");
      
      return;
   }
}