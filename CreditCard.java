/**
 * This program checks whether or not a credit card number is valid, based on
 * six different checks 
 * @author: Daniel Garces
 * @date: 09/29/2018
 * @UNI: dg3008
 */

public class CreditCard{   
    // instance variables
    private String cardNumber; //credit card number stored as string
    private boolean validStatus;// determines if credit card number is valid
    private int errorCode; //gives the number of the check that is not satisfied
    
    //constants
    private final char FIRST_DIGIT = '4';
    private final int PRODUCT_OF_FIRST_FIFTH_NINTH_DIGITS = 24;
    private final int DIVISIBILITY_CHECK = 4;
    private final int SUM_OF_DOUBLE_DIGIT_NUMBERS = 100;
        
    
    /**
    Initializes the insance variables using the given arguments
    @param creditCardNumber the credit card number as a string
    NOTE: this constructor assumes that the string is formatted correctly
    Format: XXXX-XXXX-XXXX
    */
    public CreditCard(String creditCardNumber){
        cardNumber = creditCardNumber;
        validStatus = true;
        errorCode = 0;
    }
    
    //This method finds the sum of a section of a string, based on the 
    //starting point and end point
    //@param startPoint index of first digit to be considered for the sum
    //@param endPoint index+1 of the last digit to be considered for the sum
    private int sumOfDigits(int startPoint, int endPoint){
        int sumDigits = 0;
        
        for(int i=startPoint; i<endPoint; i++){//gets the sum of all digits
            char numericalCharacter = cardNumber.charAt(i);
            if ((numericalCharacter!='-')&&(numericalCharacter!=' ')){
                int digit = Character.getNumericValue(numericalCharacter);
                sumDigits = sumDigits + digit;
            }
        }
        
        return sumDigits;
    }
    
    //This method turns a character in a given location of a stgring into a
    //numerical digit
    //@param indexLocation the index in which the character is located
    private int createDigit(int indexLocation){
        char characterForDigit = cardNumber.charAt(indexLocation);
        int digitAtIndex = Character.getNumericValue(characterForDigit);
        
        return digitAtIndex;
    }
    
    //This method checks if the first digit is 4
    private void check1(){
        char firstDigit = cardNumber.charAt(0);
        
        if (firstDigit!=FIRST_DIGIT){
            validStatus = false;
            errorCode = 1;
        }
    }
    
    //This method checks if the fourth digit is one greater than the
    //fifth digit 
    private void check2(){
        int fourthDigit = createDigit(3);
        int fifthDigit = createDigit(5);
        
        if ((fourthDigit != fifthDigit+1) && validStatus){
            validStatus = false;
            errorCode = 2;
        }
    }
    
    //This method checks if the product of the first, fifth and ninth digits
    //are 24
    private void check3(){
        int firstDigit = createDigit(0);
        int fifthDigit = createDigit(5);
        int ninthDigit = createDigit(10);
        int productFirstFifthNinthDigits = firstDigit*fifthDigit*ninthDigit; 
        
        if ((productFirstFifthNinthDigits!=PRODUCT_OF_FIRST_FIFTH_NINTH_DIGITS)
           && validStatus){
            validStatus = false;
            errorCode = 3;
        } 
    }
    
    //This method checks if the sum of all digits is evenly divisible by 4
    private void check4(){
        int totalSum = sumOfDigits(0,cardNumber.length());
        
        if (((totalSum%DIVISIBILITY_CHECK)!=0)&& validStatus){
            validStatus = false;
            errorCode = 4;
        }
    }
    
    //This method checks if the sum of the first four digits is one less than 
    //the sum of the last four digits
    private void check5(){
        int sumOfFirstFourDigits = sumOfDigits(0,4);
        int sumOfLastFourDigits = sumOfDigits(10,14);
        
        if(((sumOfFirstFourDigits)!=(sumOfLastFourDigits-1))&& validStatus){
            validStatus = false;
            errorCode = 5;
        }
    }
    
    //This method checks if you treat the first two digits as a two-digit 
    //number, and the seventh and eighth digits as a two digit number, 
    //their sum is 100
    private void check6(){
        int firstTwoDigitsNumber = Integer.parseInt(cardNumber.substring(0,2));
        int seventhEighthDigitsNumber = 
            Integer.parseInt(cardNumber.substring(7,9));
        int sum = firstTwoDigitsNumber+seventhEighthDigitsNumber;
        
        if((sum!=SUM_OF_DOUBLE_DIGIT_NUMBERS)&& validStatus){
            validStatus = false;
            errorCode = 6;
        }
    }
    
    //This mutator method checks if a credit card number is valid according
    // to the six support checks, and then modifies the validStatus to false
    // if the credit card number is not valid and the errorCode to a number
    // different than zero according to the first check that is failed
    public void check(){
        check1();
        check2();
        check3();
        check4();
        check5();
        check6();
    }
    
    //This method is an accessor that returns the validity of a credit card
    //number
    //@return validStatus boolean of the validity of a credit card number
    public boolean isValid(){
        return validStatus;
    }
    
    //this method is an accessor that returns the error code of the first 
    //check that is failed
    //@return errorCode the number of the check that is first failed
    public int getErrorCode(){
        return errorCode;
    }
    
    
}