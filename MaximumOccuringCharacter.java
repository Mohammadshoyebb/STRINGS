/**
 * Question Name: Maximum Occuring Character
 * Given a string str of lowercase alphabets, find the maximum occurring character.
 * If more than one character occurs the maximum number of times, print the lexicographically smaller character.
 *
 * Example 1:
 * Input:
 * str = testsample
 * Output:
 * e
 * Explanation:
 * 'e' is the character which is having the highest frequency.
 *
 * Example 2:
 * Input:
 * str = output
 * Output:
 * t
 * Explanation:
 * 't' and 'u' are characters with the same frequency, but 't' is lexicographically smaller.
 *
 * Your Task:
 * The task is to complete the function getMaxOccuringChar() which returns the character which is most occurring.
 *
 * Expected Time Complexity: O(N).
 * Expected Auxiliary Space: O(Number of distinct characters).
 * Note: N = |s|
 *
 * Constraints:
 * 1 ≤ |s| ≤ 100
 */

 public class MaximumOccuringCharacter{
    public static char getMaxOccuringChar(String str) {
        // Array to keep track of frequency of each character
        int[] freq = new int[26];
        
        // Traverse through the string and count frequencies
        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }
        
        // Variables to track maximum frequency and corresponding character
        int maxFreq = 0;
        char result = ' ';
        
        // Iterate through the frequency array to find the maximum occurring character
        for (int i = 0; i < 26; i++) {
            if (freq[i] > maxFreq) {
                maxFreq = freq[i];
                result = (char)('a' + i);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        String str1 = "testsample";
        String str2 = "output";
        
        System.out.println("Maximum occurring character in " + str1 + ": " + getMaxOccuringChar(str1)); // Output: e
        System.out.println("Maximum occurring character in " + str2 + ": " + getMaxOccuringChar(str2)); // Output: t
    }
}

