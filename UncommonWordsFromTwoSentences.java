/**
 * 884. Uncommon Words from Two Sentences
 * 
 * A sentence is a string of single-space separated words where each word consists 
 * only of lowercase letters. A word is uncommon if it appears exactly once in one 
 * of the sentences, and does not appear in the other sentence.
 * 
 * Given two sentences s1 and s2, return a list of all the uncommon words. You may 
 * return the answer in any order.
 * 
 * Example 1:
 * Input: s1 = "this apple is sweet", s2 = "this apple is sour"
 * Output: ["sweet","sour"]
 * 
 * Example 2:
 * Input: s1 = "apple apple", s2 = "banana"
 * Output: ["banana"]
 * 
 * Constraints:
 * 1 <= s1.length, s2.length <= 200
 * s1 and s2 consist of lowercase English letters and spaces.
 * s1 and s2 do not have leading or trailing spaces.
 * All the words in s1 and s2 are separated by a single space.
 */

import java.util.*;

public class UncommonWordsFromTwoSentences {
     /**
      * This method finds the uncommon words from two sentences.
      * 
      * Time Complexity: O(n), where n is the total number of words in both sentences.
      * Space Complexity: O(n), for storing the word count map and the resulting uncommon words.
      * 
      * @param s1 The first sentence
      * @param s2 The second sentence
      * @return A list of uncommon words from both sentences
      */
     public String[] uncommonFromSentences(String s1, String s2) {
         // Split the two sentences into arrays of words
         String[] words1 = s1.split(" ");
         String[] words2 = s2.split(" ");
         
         // Use a HashMap to store word counts from both sentences
         Map<String, Integer> wordCount = new HashMap<>();
         
         // Count occurrences of each word in the first sentence
         for (String word : words1) {
             wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
         }
         
         // Count occurrences of each word in the second sentence
         for (String word : words2) {
             wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
         }
         
         // List to store the uncommon words
         List<String> result = new ArrayList<>();
         
         // Find words that appear exactly once across both sentences
         for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
             if (entry.getValue() == 1) {
                 result.add(entry.getKey());
             }
         }
         
         // Convert the list to an array and return it
         return result.toArray(new String[0]);
     }
 
     // Main method for testing
     public static void main(String[] args) {
         UncommonWordsFromTwoSentences solution = new UncommonWordsFromTwoSentences();
         
         // Test case 1
         String s1 = "this apple is sweet";
         String s2 = "this apple is sour";
         System.out.println(Arrays.toString(solution.uncommonFromSentences(s1, s2)));  // Output: ["sweet", "sour"]
         
         // Test case 2
         String s1_2 = "apple apple";
         String s2_2 = "banana";
         System.out.println(Arrays.toString(solution.uncommonFromSentences(s1_2, s2_2)));  // Output: ["banana"]
     }
 }
 