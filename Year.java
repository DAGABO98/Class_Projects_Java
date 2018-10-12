/**
*
* This class represents a calendar year. It contains 
* a method that determines if the year is a leap year.
* 
* @author: Daniel Garces
* @date: 09/15/2018
* @UNI: dg3008
*
*/

public class Year{
    
    // declare your instance variables here
    private int year;
    final int leapYearCondition1 = 4;
    final int notLeapYearCondition = 100;
    final int leapYearCondition2 = 400;
    final int leapYearCondition3 = 1582;


    // write your constructor here

    public Year(int y){
        year = y;
    }


    public boolean isLeapYear(){
        if((year>leapYearCondition3) && ((year%leapYearCondition2)==0) 
           || (((year%notLeapYearCondition)!=0) && ((year%leapYearCondition1)==0)))
        {
          return true; 
        }
        else
        {
            return false;
        }
    }

}    

