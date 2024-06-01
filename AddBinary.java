/*
 * 
 * 67. Add Binary
Solved
Easy
Topics
Companies
Given two binary strings a and b, return their sum as a binary string.

 

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
 

Constraints:

1 <= a.length, b.length <= 104
a and b consist only of '0' or '1' characters.
Each string does not contain leading zeros except for the zero itself.

 */




public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder result = new StringBuilder();
        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;

        while (i >= 0 || j >= 0) {
            int digitA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum / 2;
            result.append(sum % 2);
        }

        if (carry > 0) {
            result.append(carry);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary solution = new AddBinary();

        // Test cases
        String a1 = "11";
        String b1 = "1";
        System.out.println(solution.addBinary(a1, b1)); // Output: "100"

        String a2 = "1010";
        String b2 = "1011";
        System.out.println(solution.addBinary(a2, b2)); // Output: "10101"
    }
}
