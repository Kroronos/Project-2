/*
 * Name: Jesse Martinez
 * Class Section: 6909
 * Instructor: Kyla McMullen
 * Due Date: October 11, 2016
 * Brief Description: Authenticates user depending upon current date.
 *  Calculates area and perimeter of rectangles and triangles. 
 * Calculates area and circumference for circles. 
 * Program detects invalid inputs and informs user of them.
 * Program will continue once authenticated until user inputs "Exit"
 */
import java.util.Scanner;
import java.security.cert.PKIXRevocationChecker.Option;
import java.text.SimpleDateFormat;
import java.util.Date;
public class ShapeMachine {
    public static void main(String[] args) {
       Scanner in = new Scanner (System.in);
       //Creates string date with current date
       String date = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
    
    //Needed variables for authentication loop    
    boolean validAuth = false;
    int loginAuth = 0;
    System.out.println("Shape Machine login");
    while ( ((loginAuth < 3)) && ((validAuth == false)) ) {
        //Increment variable loginAuth to limit attempts
        loginAuth++;
        //Ask for input for authentication
        System.out.print("What is today's day? ");
        String day = in.next();
        System.out.print("What is today's month? ");
        String month = in.next();
        System.out.print("What is today's year? ");
        String year = in.next();
        //Concatenates inputDate to reflect date form
        String inputDate = (day + "-" + month + "-" +year);
        
        //Determine if authentication is valid via string equality
        if ( inputDate.equals(date)) {
            validAuth =  true;
            System.out.println("Correct date. Welcome!");
        }
        //Inform user of failure to login
        else if (loginAuth <3) {
            System.out.println("#ERROR Login attempt #" + loginAuth + " Invalid input. Please try again." );
        }
        if ((loginAuth == 3) && (validAuth == false)) {
            System.out.println("#ERROR 3rd invalid login attempt. Terminating program.");
        }
    }
    
    //If statement required to ensure that user cannot bypass authentication
    if (validAuth == true) {
        //Print the menu and declare menu variables
        System.out.println("---Welcome to the Shape Machine---");
        System.out.println(" ");
        System.out.println("Available Options:");
        String circle = "Circles";
        System.out.println(circle);
        String rectangle = "Rectangles";
        System.out.println(rectangle);
        String triangle = "Triangles";
        System.out.println(triangle);
        String exit ="Exit";
        System.out.println(exit);
        //Scans user selection
        String userInput = in.next();
        
        //Do while loop conditional dependent on user input
        while (!(userInput.equals(exit))) {
            //User selects circle
            if (userInput.equals(circle)) {
                System.out.print("Circles selected. Please enter the radius: ");
                //Request radius
                double circleRadius = in.nextDouble();
                
                //Checks if input is correct
                while (circleRadius <= 0) {
                    System.out.print("#ERROR Negative input. Please input the radius again: ");
                    circleRadius = in.nextDouble();
                }
                
              //Basic Calculations
                    double circleArea = Math.PI * circleRadius * circleRadius;
                    double circleCircumference = 2 * Math.PI * circleRadius; 
                    
                    System.out.println("The circumference is: " + circleCircumference);
                    System.out.println("The area is: " + circleArea);
                
                    //Obtain circleCircumference length
                    String cCircumferenceString = String.valueOf(circleCircumference);
                    cCircumferenceString = cCircumferenceString.replaceAll("[.]","");
                    int cCircumferenceLength = cCircumferenceString.length();
                    System.out.println("Total number of digits in the circumference is: " + cCircumferenceLength);
                    
                    //Obtain circleArea length
                    String cAreaString = String.valueOf(circleArea);
                    cAreaString = cAreaString.replaceAll("[.]","");
                    int cAreaLength = cAreaString.length();
                    System.out.println("Total number of digits in the area is : " + cAreaLength);
               
                    //Asks user whether loop should continue, in.next is used to prevent double output from \n
                    //Return to menu and ask for new input
                    System.out.println("");
                    System.out.println("---Welcome to the Shape Machine---");
                    System.out.println(" ");
                    System.out.println("Available Options:");
                    System.out.println(circle);
                    System.out.println(rectangle);
                    System.out.println(triangle);
                    System.out.println(exit);
                    userInput = in.next();
                }   
            
            //User selects rectangle
            if (userInput.equals(rectangle)) {
                System.out.print("Rectangles selected. Please enter the 2 sides: ");
                double rectangleLength = in.nextDouble();
                double rectangleWidth = in.nextDouble();
                
                //Tests for invalid input
                if ((rectangleLength <= 0) || (rectangleWidth <= 0)) {
                    //Loop until user obeys and enters valid value
                    while ((rectangleLength <= 0) || (rectangleWidth <= 0)) {
                        System.out.print("#ERROR Negative input. Please input the 2 sides again: ");
                        rectangleLength= in.nextDouble();
                        rectangleWidth = in.nextDouble();
                          
                    }
                } 
                if ((rectangleLength > 0) || (rectangleWidth > 0)) {
                    //Basic Calculations
                    double rectangleArea = rectangleLength * rectangleWidth;
                    double rectanglePerimeter = (2 * rectangleLength) + (2 * rectangleWidth);
                    
                    System.out.println("The area is: " + rectangleArea);
                    System.out.println("The perimeter is: " + rectanglePerimeter);
                    
                    //Obtain rectangleArea length 
                    String rAreaString = String.valueOf(rectangleArea);
                    //Removes decimals
                    rAreaString = rAreaString.replaceAll("[.]","");
                    int rAreaLength = rAreaString.length();
                    System.out.println("Total number of digits in the area is: " + rAreaLength);
                    
                    //Obtain rectanglePerimeter length
                    String rPerimeterString = String.valueOf(rectanglePerimeter);
                    //Removes decimals
                    rPerimeterString = rPerimeterString.replaceAll("[.]","");
                    int rPerimeterLength = rPerimeterString.length();
                    System.out.println("Total number of digits in the perimeter is: " + rPerimeterLength);
                    
                    //Asks user whether loop should continue, in.next is used to prevent double output from \n
                  //Return to menu and ask for new input
                    System.out.println("");
                    System.out.println("---Welcome to the Shape Machine---");
                    System.out.println(" ");
                    System.out.println("Available Options:");
                    System.out.println(circle);
                    System.out.println(rectangle);
                    System.out.println(triangle);
                    System.out.println(exit);
                    userInput = in.next();
                }

            }
            //User selects triangle
            if (userInput.equals(triangle)) {
                //Request dimensions
                System.out.print("Triangles selected. Please enter the 3 sides: ");
                double triangleSide1 = in.nextDouble();
                double triangleBase = in.nextDouble();
                double triangleSide2 = in.nextDouble();
                boolean validTriangle = true;
                
                //Check for invalid input
                if ((triangleSide1 <= 0) || (triangleSide2 <= 0) || (triangleBase <=0)) {
                   
                   while ((triangleSide1 <= 0) || (triangleSide2 <= 0) || (triangleBase <=0)) {
                       System.out.print("#ERROR Negative input. Please input the 3 sides again: ");
                       triangleSide1 = in.nextDouble();
                       triangleBase = in.nextDouble();
                       triangleSide2 = in.nextDouble();  
                   }
                }
               
                //Check to see if it is triangle 
               if ((triangleSide1 + triangleSide2 < triangleBase) || (triangleSide2 + triangleBase < triangleSide1) || (triangleSide1 + triangleBase < triangleSide2)) {
                   validTriangle = false;
                   System.out.println("#ERROR Triangle is not valid. Returning to menu.");
                    
                   //Return to menu and ask for new input
                    System.out.println("");
                    System.out.println("---Welcome to the Shape Machine---");
                    System.out.println(" ");
                    System.out.println("Available Options:");
                    System.out.println(circle);
                    System.out.println(rectangle);
                    System.out.println(triangle);
                    System.out.println(exit);
                    userInput = in.next();
             }
               
               if ( ((triangleSide1 > 0) || (triangleSide2 > 0) || (triangleBase > 0)) && (validTriangle != false)) {
                //Basic Calculations
                    
                    double trianglePerimeter = triangleBase + triangleSide1 + triangleSide2;
                    double semiPerimeter = (trianglePerimeter / 2); 
                    double triangleArea = Math.sqrt((semiPerimeter * (semiPerimeter - triangleBase) * (semiPerimeter - triangleSide1) * (semiPerimeter - triangleSide2)));
                    
                    if ((triangleBase == triangleSide1) && (triangleBase ==  triangleSide2) && (triangleSide1 == triangleSide2))
                        System.out.println("The triangle is: Equilateral");
                    else if ((triangleBase != triangleSide1) && (triangleBase !=  triangleSide2) && (triangleSide1 != triangleSide2))
                        System.out.println("The triangle is: Scalene");
                    else
                        System.out.println("The triangle is: Isosceles");
                    
                    System.out.println("The perimeter is: " + trianglePerimeter);
                    System.out.println("The area is: " + triangleArea);
                    
                    //Determine type of triangle
                    
                    
                  //Obtain trianglePerimeter length
                    String tPerimeterString = String.valueOf(trianglePerimeter);
                    //Remove decimals
                    tPerimeterString = tPerimeterString.replaceAll("[.]","");
                    int tPerimeterLength = tPerimeterString.length();
                    System.out.println("Total number of digits in the perimeter is: " + tPerimeterLength);
                    
                    //Obtain triangleArea length
                    String tAreaString = String.valueOf(triangleArea);
                    //Remove decimals
                    tAreaString = tAreaString.replaceAll("[.]","");
                    int tAreaLength = tAreaString.length();
                    System.out.println("Total number of digits in the area is: " + tAreaLength);
                    
               
                    
                    //Asks user whether loop should continue, in.next is used to prevent double output from \n
                  //Return to menu and ask for new input
                    System.out.println("");
                    System.out.println("---Welcome to the Shape Machine---");
                    System.out.println(" ");
                    System.out.println("Available Options:");
                    System.out.println(circle);
                    System.out.println(rectangle);
                    System.out.println(triangle);
                    System.out.println(exit);
                    userInput = in.next();
                }
            }
          
                //Asks user to enter valid input if invalid input is entered
            
            if (!(userInput.equals(triangle)) && !(userInput.equals(rectangle)) && !(userInput.equals(circle)) && !(userInput.equals(exit))) {
                System.out.println("#ERROR Invalid option. Please try again.");
                System.out.println("");
                System.out.println("---Welcome to the Shape Machine---");
                System.out.println(" ");
                System.out.println("Available Options:");
                System.out.println(circle);
                System.out.println(rectangle);
                System.out.println(triangle);
                System.out.println(exit);
                userInput = in.next();
                
           }
               
               
        } 
        
        //Informs user that they are terminating program
        System.out.println("Terminating the program. Have a nice day!");
    }
}
    
    
   
    
    
    
    
    }


