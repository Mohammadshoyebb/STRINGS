/*
1170. Compare Strings by Frequency of the Smallest Character
Medium
Topics: String, Array

Let the function f(s) be the frequency of the lexicographically smallest character in a non-empty string s. 
For example, if s = "dcce" then f(s) = 2 because the lexicographically smallest character is 'c', which has a frequency of 2.

You are given an array of strings words and another array of query strings queries. 
For each query queries[i], count the number of words in words such that f(queries[i]) < f(W) for each W in words.

Return an integer array answer, where each answer[i] is the answer to the ith query.

Example 1:
Input: queries = ["cbd"], words = ["zaaaz"]
Output: [1]
Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").

Example 2:
Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
Output: [1,2]
Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").

Constraints:
1 <= queries.length <= 2000
1 <= words.length <= 2000
1 <= queries[i].length, words[i].length <= 10
queries[i][j], words[i][j] consist of lowercase English letters.
*/

import java.util.Arrays;

public class CompareStringsByFrequency {

    // Helper function to compute the frequency of the smallest character
    public static int f(String s) {
        char minChar = 'z';  // Initialize to the highest possible char
        int count = 0;
        
        for (char c : s.toCharArray()) {
            if (c < minChar) {  // Found a new smaller character
                minChar = c;
                count = 1;  // Reset count for the new smallest character
            } else if (c == minChar) {  // Found another occurrence of the smallest character
                count++;
            }
        }
        
        return count;  // Return the frequency of the smallest character
    }

    // Approach 1: Direct Comparison
    public static int[] numSmallerByFrequencyDirect(String[] queries, String[] words) {
        int[] wordFrequencies = new int[words.length];
        int[] queryFrequencies = new int[queries.length];

        // Compute frequencies for words
        for (int i = 0; i < words.length; i++) {
            wordFrequencies[i] = f(words[i]);
        }

        // Compute frequencies for queries
        for (int i = 0; i < queries.length; i++) {
            queryFrequencies[i] = f(queries[i]);
        }

        // Result array
        int[] result = new int[queries.length];

        // Compare each query frequency with word frequencies
        for (int i = 0; i < queries.length; i++) {
            int count = 0;
            for (int wordFreq : wordFrequencies) {
                if (queryFrequencies[i] < wordFreq) {
                    count++;
                }
            }
            result[i] = count;
        }

        return result;
    }

    // Approach 2: Optimized with Sorting and Binary Search
    public static int[] numSmallerByFrequencyOptimized(String[] queries, String[] words) {
        int[] wordFrequencies = new int[words.length];
        int[] queryFrequencies = new int[queries.length];

        // Compute frequencies for words
        for (int i = 0; i < words.length; i++) {
            wordFrequencies[i] = f(words[i]);
        }

        // Compute frequencies for queries
        for (int i = 0; i < queries.length; i++) {
            queryFrequencies[i] = f(queries[i]);
        }

        // Sort the wordFrequencies array for efficient comparison
        Arrays.sort(wordFrequencies);

        // Result array
        int[] result = new int[queries.length];

        // Compare each query frequency with word frequencies using binary search
        for (int i = 0; i < queries.length; i++) {
            int count = wordFrequencies.length - binarySearch(wordFrequencies, queryFrequencies[i]);
            result[i] = count;
        }

        return result;
    }

    // Helper function for binary search
    private static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {
        String[] queries = {"cbd", "bbb", "cc"};
        String[] words = {"zaaaz", "a", "aa", "aaa", "aaaa"};

        // Using the direct comparison approach
        int[] resultDirect = numSmallerByFrequencyDirect(queries, words);
        System.out.print("Direct Approach Results: ");
        for (int res : resultDirect) {
            System.out.print(res + " ");
        }
        System.out.println();

        // Using the optimized approach
        int[] resultOptimized = numSmallerByFrequencyOptimized(queries, words);
        System.out.print("Optimized Approach Results: ");
        for (int res : resultOptimized) {
            System.out.print(res + " ");
        }
    }
}
