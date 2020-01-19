/******************************************
* Author: Hai Le
* Created on: 1/17/2020
* Purpose: Testing two strings if they're the reverse of one another
*******************************************/

import java.util.Scanner;

public class ReverseStringTester {
   public static void main(String[] args)
   {
      //User's inputs
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the first word: ");
      String s = input.nextLine();
      System.out.print("Enter the second word: ");
      String s2 = input.nextLine();
      
      //Checking if the first word is the reverse of the second one
      if(isReverse(s,s2)) 
         System.out.println(s + " is the reverse of " + s2);
      else
         System.out.println(s + " is not the reverse of " + s2);
   }
   
   //Returning true if the first word is the reverse of the second one
   public static boolean isReverse(String s, String s2)
   { 
      return s2.equals(reverse(s));
   }
   
   //Reading each character of the word
   //and store them in result variable
   public static String reverse(String s) {
      String result = "";
      for (int i = 0; i < s.length(); i++) {
         result = s.charAt(i) + result;
      }
      return result;
   }
   
}
