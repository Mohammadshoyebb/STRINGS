/**
 * 2000. Reverse Prefix of Word
 * Given a 0-indexed string word and a character ch, reverse the segment of word
 * that starts at index 0 and ends at the index of the first occurrence of ch (inclusive).
 * If the character ch does not exist in word, do nothing.
 * 
 * Example 1:
 * Input: word = "abcdefd", ch = "d"
 * Output: "dcbaefd"
 * Explanation: The first occurrence of "d" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "dcbaefd".
 * 
 * Example 2:
 * Input: word = "xyxzxe", ch = "z"
 * Output: "zxyxxe"
 * Explanation: The first and only occurrence of "z" is at index 3.
 * Reverse the part of word from 0 to 3 (inclusive), the resulting string is "zxyxxe".
 * 
 * Example 3:
 * Input: word = "abcd", ch = "z"
 * Output: "abcd"
 * Explanation: "z" does not exist in word.
 * You should not do any reverse operation, the resulting string is "abcd".
 * 
 * Constraints:
 * 1 <= word.length <= 250
 * word consists of lowercase English letters.
 * ch is a lowercase English letter.
 */
public class ReversePrefixOfWord {
    public static void main(String[] args) {
        // Test cases
        System.out.println(reversePrefix("abcdefd", 'd')); // Output: "dcbaefd"
        System.out.println(reversePrefix("xyxzxe", 'z'));  // Output: "zxyxxe"
        System.out.println(reversePrefix("abcd", 'z'));    // Output: "abcd"
    }

    public static String reversePrefix(String word, char ch) {
        StringBuilder reversedPrefix = new StringBuilder();
        int chIndex = -1;
        
        // Find the first occurrence of `ch`
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                chIndex = i;
                break;
            }
        }
        
        // If `ch` is found, reverse the prefix up to and including `ch`
        if (chIndex != -1) {
            for (int i = chIndex; i >= 0; i--) {
                reversedPrefix.append(word.charAt(i));
            }
            // Append the remaining part of the string
            reversedPrefix.append(word.substring(chIndex + 1));
        } else {
            // If `ch` is not found, return the original word
            return word;
        }
        
        return reversedPrefix.toString();
    }
}
