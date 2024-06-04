/**
 * 409. Longest Palindrome
 * Solved
 * Easy
 * 
 * Given a string s which consists of lowercase or uppercase letters, 
 * return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome.
 *
 * Example 1:
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation: One longest palindrome that can be built is "dccaccd", whose length is 7.
 *
 * Example 2:
 * Input: s = "a"
 * Output: 1
 * Explanation: The longest palindrome that can be built is "a", whose length is 1.
 *
 * Constraints:
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 */

 import java.util.HashMap;
 import java.util.HashSet;
 
 public class LongestPalindrome {
     
     // Method using HashMap
     public int longestPalindromeUsingMap(String s) {
         HashMap<Character, Integer> countMap = new HashMap<>();
         
         // Count the frequency of each character
         for (char c : s.toCharArray()) {
             countMap.put(c, countMap.getOrDefault(c, 0) + 1);
         }
         
         int length = 0;
         boolean hasOdd = false;
         
         // Calculate the length of the longest palindrome
         for (int count : countMap.values()) {
             if (count % 2 == 0) {
                 length += count;
             } else {
                 length += count - 1; // add the even part of the odd count
                 hasOdd = true;       // remember that we have an odd count
             }
         }
         
         // If there was at least one odd count, we can add one character in the middle
         if (hasOdd) {
             length += 1;
         }
         
         return length;
     }
     
     // Method using HashSet
     public int longestPalindromeUsingSet(String s) {
         HashSet<Character> set = new HashSet<>();
         int res = 0;
         
         for (char ch : s.toCharArray()) {
             if (set.contains(ch)) {
                 res += 2;
                 set.remove(ch);
             } else {
                 set.add(ch);
             }
         }
         
         if (set.size() > 0) {
             res += 1;
         }
         
         return res;
     }
     
     // Fastest Method using array
     public int longestPalindromeUsingArray(String s) {
         int[] array = new int[58];
         int count = 0, odd = 0;
 
         for (char each : s.toCharArray()) {
             array[each - 'A']++;
         }
 
         for (int each : array) {
             if (each % 2 == 0 && each != 0) {
                 count += each;
             } else if (each % 2 == 1 && each != 1) {
                 count += each - 1; 
                 odd = 1;
             } else if (each == 1) {
                 odd = 1;
             }
         }
 
         return count + odd;
     }
 
     public static void main(String[] args) {
         LongestPalindrome solution = new LongestPalindrome();


         
         System.out.println();
         System.out.println("First Method:");
         String s1 = "abccccdd";
         System.out.println(solution.longestPalindromeUsingMap(s1));  // Output: 7
         System.out.println(solution.longestPalindromeUsingSet(s1));  // Output: 7
         System.out.println(solution.longestPalindromeUsingArray(s1)); // Output: 7
         

         System.out.println();
         System.out.println("Second Method:");
         String s2 = "a";
         System.out.println(solution.longestPalindromeUsingMap(s2));  // Output: 1
         System.out.println(solution.longestPalindromeUsingSet(s2));  // Output: 1
         System.out.println(solution.longestPalindromeUsingArray(s2)); // Output: 1
         
        System.out.println();
         System.out.println("Third Method: Fastest Method");
         String s3 = "Aa";
         System.out.println(solution.longestPalindromeUsingMap(s3));  // Output: 1
         System.out.println(solution.longestPalindromeUsingSet(s3));  // Output: 1
         System.out.println(solution.longestPalindromeUsingArray(s3)); // Output: 1
     }
 }
 
