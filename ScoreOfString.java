/*
3110. Score of a String
Solved
Easy
Topics
Companies
Hint
You are given a string s. The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.

Return the score of s.

Example 1:
Input: s = "hello"
Output: 13
Explanation:
The ASCII values of the characters in s are: 'h' = 104, 'e' = 101, 'l' = 108, 'o' = 111. So, the score of s would be |104 - 101| + |101 - 108| + |108 - 108| + |108 - 111| = 3 + 7 + 0 + 3 = 13.

Example 2:
Input: s = "zaz"
Output: 50
Explanation:
The ASCII values of the characters in s are: 'z' = 122, 'a' = 97. So, the score of s would be |122 - 97| + |97 - 122| = 25 + 25 = 50.

Constraints:
2 <= s.length <= 100
s consists only of lowercase English letters.
*/

public class ScoreOfString {
    public static int scoreOfString(String s) {
        int score = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            score += Math.abs(s.charAt(i) - s.charAt(i + 1));
        }
        return score;
    }

    public static void main(String[] args) {
        // Example usage:
        System.out.println(scoreOfString("hello")); // Output: 13
        System.out.println(scoreOfString("zaz"));   // Output: 50
    }
}

/*
Dry Run Example:

1. Input: "hello"
   - ASCII values: 'h' = 104, 'e' = 101, 'l' = 108, 'l' = 108, 'o' = 111.
   - Calculation of differences:
     - |104 - 101| = 3
     - |101 - 108| = 7
     - |108 - 108| = 0
     - |108 - 111| = 3
   - Summing these values: 3 + 7 + 0 + 3 = 13

2. Input: "zaz"
   - ASCII values: 'z' = 122, 'a' = 97, 'z' = 122.
   - Calculation of differences:
     - |122 - 97| = 25
     - |97 - 122| = 25
   - Summing these values: 25 + 25 = 50
*/

