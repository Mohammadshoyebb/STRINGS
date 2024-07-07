// 3. Longest Substring Without Repeating Characters
// Given a string s, find the length of the longest substring without repeating characters.
//
// Example 1:
// Input: s = "abcabcbb"
// Output: 3
// Explanation: The answer is "abc", with the length of 3.
//
// Example 2:
// Input: s = "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
// Example 3:
// Input: s = "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
// Constraints:
// 0 <= s.length <= 5 * 10^4
// s consists of English letters, digits, symbols and spaces.

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        // Map to store the last index of each character
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;

        // Iterate through the string
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);

            // If the character is already in the map and is in the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                // Move the start to the right of the duplicate character
                start = map.get(currentChar) + 1;
            }

            // Update the last index of the current character
            map.put(currentChar, end);

            // Calculate the length of the current window
            int currentLength = end - start + 1;

            // Update the maximum length
            maxLength = Math.max(maxLength, currentLength);
        }

        return maxLength;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();

        String s1 = "abcabcbb";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s1));

        String s2 = "bbbbb";
        System.out.println("Input: " + s2);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s2));

        String s3 = "pwwkew";
        System.out.println("Input: " + s3);
        System.out.println("Output: " + solution.lengthOfLongestSubstring(s3));
    }
}
``
