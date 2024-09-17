/*
 * 592. Fraction Addition and Subtraction
Medium
Topics
Companies
Given a string expression representing an expression of fraction addition and subtraction, return the calculation result in string format.

The final result should be an irreducible fraction. If your final result is an integer, change it to the format of a fraction that has a denominator 1. So in this case, 2 should be converted to 2/1.

 

Example 1:

Input: expression = "-1/2+1/2"
Output: "0/1"
Example 2:

Input: expression = "-1/2+1/2+1/3"
Output: "1/3"
Example 3:

Input: expression = "1/3-1/2"
Output: "-1/6"
 

Constraints:

The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
Each fraction (input and output) has the format ±numerator/denominator. If the first input fraction or the output is positive, then '+' will be omitted.
The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always be in the range [1, 10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
The number of given fractions will be in the range [1, 10].
The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 */


 import java.util.*;

 public class FractionAdditionAndSubtraction {
     
     // Helper function to calculate the Greatest Common Divisor (GCD)
     private int gcd(int a, int b) {
         return b == 0 ? a : gcd(b, a % b);
     }
 
     // Helper function to parse the fractions and perform the addition/subtraction
     public String fractionAddition(String expression) {
         int numerator = 0, denominator = 1; // Start with 0/1
         
         int index = 0;
         while (index < expression.length()) {
             // Parse the sign
             int sign = 1;
             if (expression.charAt(index) == '+' || expression.charAt(index) == '-') {
                 sign = expression.charAt(index) == '-' ? -1 : 1;
                 index++;
             }
 
             // Parse the numerator
             int num = 0;
             while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                 num = num * 10 + (expression.charAt(index) - '0');
                 index++;
             }
 
             // Skip the '/'
             index++; 
 
             // Parse the denominator
             int denom = 0;
             while (index < expression.length() && Character.isDigit(expression.charAt(index))) {
                 denom = denom * 10 + (expression.charAt(index) - '0');
                 index++;
             }
 
             // Adjust the current numerator and denominator
             num *= sign;
             numerator = numerator * denom + num * denominator;
             denominator *= denom;
 
             // Simplify the fraction
             int gcd = gcd(Math.abs(numerator), denominator);
             numerator /= gcd;
             denominator /= gcd;
         }
 
         return numerator + "/" + denominator;
     }
 
     public static void main(String[] args) {
         FractionAdditionAndSubtraction solution = new FractionAdditionAndSubtraction();
         
         // Test cases
         System.out.println(solution.fractionAddition("-1/2+1/2"));  // Output: "0/1"
         System.out.println(solution.fractionAddition("-1/2+1/2+1/3"));  // Output: "1/3"
         System.out.println(solution.fractionAddition("1/3-1/2"));  // Output: "-1/6"
     }
 }
 