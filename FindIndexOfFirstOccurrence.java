/*
 * 28. Find the Index of the First Occurrence in a String
Solved
Easy
Topics
Companies
Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

Example 1:

Input: haystack = "sadbutsad", needle = "sad"
Output: 0
Explanation: "sad" occurs at index 0 and 6.
The first occurrence is at index 0, so we return 0.
Example 2:

Input: haystack = "leetcode", needle = "leeto"
Output: -1
Explanation: "leeto" did not occur in "leetcode", so we return -1.
 

Constraints:

1 <= haystack.length, needle.length <= 104
haystack and needle consist of only lowercase English characters.
 */




public class FindIndexOfFirstOccurrence {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1; // Handle invalid input
        }
        
        int hayLen = haystack.length();
        int needleLen = needle.length();
        
        for (int i = 0; i <= hayLen - needleLen; i++) {
            if (haystack.substring(i, i + needleLen).equals(needle)) {
                return i; // Found a match, return the index
            }
        }
        
        return -1; // No match found
    }
    
    public static void main(String[] args) {
        FindIndexOfFirstOccurrence solution = new FindIndexOfFirstOccurrence();
        
        // Test cases
        String haystack1 = "sadbutsad";
        String needle1 = "sad";
        System.out.println("Index of first occurrence of \"" + needle1 + "\" in \"" + haystack1 + "\": " + solution.strStr(haystack1, needle1)); // Output: 0
        
        String haystack2 = "leetcode";
        String needle2 = "leeto";
        System.out.println("Index of first occurrence of \"" + needle2 + "\" in \"" + haystack2 + "\": " + solution.strStr(haystack2, needle2)); // Output: -1
    }
}


//===============================================================ANOTHER METHOD===========================================================================================

/*
 * class Solution {
    public int strStr(String haystack, String needle) {
        if((haystack).contains(needle)){
            return haystack.indexOf(needle);
        }
        return -1;
    }
 }
 */