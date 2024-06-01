
/*
 * 1370. Increasing Decreasing String
Solved
Easy
Topics
Companies
Hint
You are given a string s. Reorder the string using the following algorithm:

Pick the smallest character from s and append it to the result.
Pick the smallest character from s which is greater than the last appended character to the result and append it.
Repeat step 2 until you cannot pick more characters.
Pick the largest character from s and append it to the result.
Pick the largest character from s which is smaller than the last appended character to the result and append it.
Repeat step 5 until you cannot pick more characters.
Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

Return the result string after sorting s with this algorithm.

 

Example 1:

Input: s = "aaaabbbbcccc"
Output: "abccbaabccba"
Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
After steps 4, 5 and 6 of the first iteration, result = "abccba"
First iteration is done. Now s = "aabbcc" and we go back to step 1
After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba"
Example 2:

Input: s = "rat"
Output: "art"
Explanation: The word "rat" becomes "art" after re-ordering it with the mentioned algorithm.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.
 */



 

import java.util.*;

public class IncreasingDecreasingString {
    public String sortString(String s) {
        // Step 1: Count the frequency of each character
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        // Step 2: Initialize an empty result string
        StringBuilder result = new StringBuilder();

        // Step 3: Iterate through characters repeatedly in ascending and descending order
        while (result.length() < s.length()) {
            // Ascending order: Append smallest characters
            for (int i = 0; i < 26; i++) {
                if (count[i] > 0) {
                    result.append((char)('a' + i));
                    count[i]--;
                }
            }
            
            // Descending order: Append largest characters
            for (int i = 25; i >= 0; i--) {
                if (count[i] > 0) {
                    result.append((char)('a' + i));
                    count[i]--;
                }
            }
        }

        // Step 5: Return the result string
        return result.toString();
    }

    public static void main(String[] args) {
        IncreasingDecreasingString solution = new IncreasingDecreasingString();

        // Example 1
        String s1 = "aaaabbbbcccc";
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: \"" + solution.sortString(s1) + "\"");

        // Example 2
        String s2 = "rat";
        System.out.println("\nExample 2:");
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Output: \"" + solution.sortString(s2) + "\"");
    }
}



//=============================================================FASTER CODE================================================
/*
 * class Solution {
    public String sortString(String s) {
        
        StringBuilder result = new StringBuilder();
        int[] freq  = new int[26];
        for(char c: s.toCharArray()){
            freq[c-'a']++;
        }
        int remaining = s.length();
        while(remaining!=0){
            for(int i=0;i<26&&remaining!=0;i++){
                if(freq[i]!=0){
                    freq[i]--;
                    result.append((char)(i+'a'));
                    remaining--;
                }
            }
            for(int i=25;i>=0&&remaining!=0;i--){
                if(freq[i]!=0){
                    freq[i]--;
                    result.append((char)(i+'a'));
                    remaining--;
                }
            }
        }
        return result.toString();
    }
}
 */