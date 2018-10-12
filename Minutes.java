/**
 * This program converts a number of hours, days, and years into minutes.
 * 
 * @author: Daniel Garces
 * @date: 09/14/2018
 * @UNI: dg3008
 */

import java.util.Scanner;

public class Minutes{
    
    public static void main(String[] args){
        
        Scanner input = new Scanner(System.in);
        double hours = 0; // declare and intialize variables
        double days = 0;
        double weeks =0;
        double years = 0;
        double minutes = 0;
        final double minutesPerHour = 60.0; //establish constants
        final double daysPerWeek = 7.0;
        final double hoursPerDay = 24.0;
        final double daysPerYear = 365.0;
      
        System.out.print("Number of hours: "); //asks the user for input
        if(input.hasNextDouble() && ((hours = input.nextDouble())>=0))
        {
            minutes = minutes + (hours*minutesPerHour); //increases the minute count
        }
        else
        {
            System.out.println("Input not recognized, please enter a positive number");
            return;
        }
      
        System.out.print("Number of days: ");//asks the user for input
        if(input.hasNextDouble() && ((days = input.nextDouble())>=0))
        {
            minutes = minutes + (days*hoursPerDay*minutesPerHour);//increases the minute count
        }
        else
        {
            System.out.println("Input not recognized, please enter a positive number");
            return;
        }
      
        System.out.print("Number of weeks: ");//asks the user for input
        if(input.hasNextDouble() && ((weeks = input.nextDouble())>=0))
        {
            minutes = minutes + (weeks*daysPerWeek*hoursPerDay*minutesPerHour); //increases the minute count
        }
        else
        {
            System.out.println("Input not recognized, please enter a positive number");
            return;
        }
      
        System.out.print("Number of years: ");//asks the user for input
        if(input.hasNextDouble() && ((years = input.nextDouble())>=0))
        {
            minutes = minutes + (years*daysPerYear*hoursPerDay*minutesPerHour); //increases the minute count
        }
        else
        {
            System.out.println("Input not recognized, please enter a positive number");
            return;
        }
        // prints the results
        System.out.println("There are: "+minutes+" minutes in "+years+" years, "+days+
                          " days, "+weeks+ " weeks, and "+hours+" hours.");
        
    }
}
 
