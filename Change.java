/**
 * This program determines how to provide change given the amount received
 * and the amount due.
 * 
 * @author: Daniel Garces
 * @date: 09/14/2018
 * @UNI: dg3008
 */

import java.util.Scanner;

public class Change{
  
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        
        // declare and intialize variables
        int balance = 0;
        int numberPennies = 0; 
        int numberNickels = 0;
        int numberDimes = 0;
        int numberQuarters = 0;
        int numberDollars = 0;
      
        // establish constants
        final int valueNickel = 5;
        final int valueDime = 10;
        final int valueQuarter = 25;
        final int valueDollar = 100;
        
        System.out.print("Amount due in pennies: "); //asks the user for input
        if(input.hasNextInt())
        {
            int amountDue = input.nextInt();
            balance = balance - amountDue;
        }
        else
        {
            System.out.println("Input not recognized, please enter an integer amount of"+
                               " pennies");
            return;
        }
      
        System.out.print("Amount received in pennies: "); //asks the user for input
        if(input.hasNextInt())
        {
            int amountReceived = input.nextInt();
            balance = balance + amountReceived;
        }
        else
        {
            System.out.println("Input not recognized, please enter an integer amount of"+
                               " pennies");
            return;
        }
      
        if(balance<=0)
        {
            System.out.println("The costumer still owes "+(-1*balance)+" pennies.");
        }
        else
        {
            numberDollars = balance / valueDollar;
            balance = balance % valueDollar;
            numberQuarters = balance / valueQuarter;
            balance = balance % valueQuarter;
            numberDimes = balance / valueDime;
            balance = balance % valueDime;
            numberNickels = balance / valueNickel;
            balance = balance % valueNickel;
            numberPennies = balance;
            
            System.out.println("The costumer should receive "+numberDollars+" dollars, "
                              +numberQuarters+" quarters, "+numberDimes+" dimes, "+
                              numberNickels+" nickels, and "+numberPennies+" pennies.");
        }
    }





}	
