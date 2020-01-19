/******************************************
* Author: Hai Le
* Created on: 1/17/2020
* Purpose: Translating string inputs into morse code
*******************************************/

import java.util.Scanner;

public class MorseCodeEncoder 
{
   public static void main(String[] args)
   {
      //Array that stores English characters
      char[] engChar = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
                  'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 
                  'Y', 'Z'};
      //Array that stores morse code
      String[] morseCode = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", 
                ".---", "-.-", ".-..", "--", "-.", "---", ".---.", "--.-", ".-.",
                "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
     
      //Get user's input for translation  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a word to be converted to Morse code: ");
      String inputString = input.nextLine().toUpperCase();
      
      //Array that stores individual characters of user's input
      char[] characters = inputString.toCharArray();
      
      //Creating an empty string to store morsecode
      String string = "";
      
      //Looping through the user's input string
      for (int i = 0; i < characters.length; i++)
      {
         //Looping through the array that stores English characters declared above
         for (int j = 0; j < engChar.length; j++)
         {
            //Looping through the engChar array to find the matching characters 
            //that are in user's input string
            //then looks for the character's associated morsecode 
            //and store the morsecode in the string variable 
            if (engChar[j] == characters[i])
               string += morseCode[j] + " ";
         }
      }
      System.out.println(string); //display morsecode 
   }
   
     
}
