
/**
 * Liam works as a data analyst for a company that stores massive amounts of numerical data.
 * He has been tasked with determining how many commas are used when writing numbers in the range of 1 to N (inclusive) in a specific format.
 * 
 * In this format, if numbers are more than four digits long, commas are used to separate the numbers into groups of three, starting from the right for the representation of the number.
 * Your task is to help Liam find and return an integer value representing the total number of commas used when writing all the integers in the range of 1 to N.
 * 
 * Input Specification:
 * input1: An integer value N, representing the number range.
 * 
 * Output Specification:
 * Return an integer value representing total number of commas used when writing all the integers in the range of 1 to N.
 */

 public class UserMainCode {
    // Method to calculate total number of commas used in the range from 1 to N
    public static int findCommas(int input1) {
        int commasCount = 0;
        
        // 4-digit numbers (1,000 - 9,999)
        if (input1 >= 1000) {
            commasCount += Math.min(input1, 9999) - 999;
        }
        
        // 5-digit numbers (10,000 - 99,999)
        if (input1 >= 10000) {
            commasCount += (Math.min(input1, 99999) - 9999);
        }
        
        // 6-digit numbers (100,000 - 999,999)
        if (input1 >= 100000) {
            commasCount += (Math.min(input1, 999999) - 99999);
        }
        
        // 7-digit numbers (1,000,000 - 9,999,999)
        if (input1 >= 1000000) {
            commasCount += 2 * (Math.min(input1, 9999999) - 999999);
        }
        
        // 8-digit numbers (10,000,000 - 99,999,999)
        if (input1 >= 10000000) {
            commasCount += 2 * (Math.min(input1, 99999999) - 9999999);
        }
        
        // 9-digit numbers (100,000,000 - 999,999,999)
        if (input1 >= 100000000) {
            commasCount += 2 * (Math.min(input1, 999999999) - 99999999);
        }
        
        // 10-digit numbers (1,000,000,000 - 9,999,999,999)
        if (input1 >= 1000000000) {
            commasCount += 3 * (Math.min(input1, 9999999999L) - 999999999);
        }
        
        return commasCount;
    }
    
    // Main method to test the findCommas function
    public static void main(String[] args) {
        // Test cases
        int input1_1 = 1010;
        int input1_2 = 95;
        
        // Expected outputs
        int expectedOutput1 = 11;
        int expectedOutput2 = 0;
        
        // Testing findCommas method
        int output1 = findCommas(input1_1);
        int output2 = findCommas(input1_2);
        
        // Printing results
        System.out.println("Input: " + input1_1 + ", Expected Output: " + expectedOutput1 + ", Actual Output: " + output1);
        System.out.println("Input: " + input1_2 + ", Expected Output: " + expectedOutput2 + ", Actual Output: " + output2);
    }
}
