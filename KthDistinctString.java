/*
2053. Kth Distinct String in an Array
Solved
Easy
Topics
Companies
Hint
A distinct string is a string that is present only once in an array.

Given an array of strings arr, and an integer k, return the kth distinct string present in arr. If there are fewer than k distinct strings, return an empty string "".

Note that the strings are considered in the order in which they appear in the array.

Example 1:
Input: arr = ["d","b","c","b","c","a"], k = 2
Output: "a"
Explanation:
The only distinct strings in arr are "d" and "a".
"d" appears 1st, so it is the 1st distinct string.
"a" appears 2nd, so it is the 2nd distinct string.
Since k == 2, "a" is returned. 

Example 2:
Input: arr = ["aaa","aa","a"], k = 1
Output: "aaa"
Explanation:
All strings in arr are distinct, so the 1st string "aaa" is returned.

Example 3:
Input: arr = ["a","b","a"], k = 3
Output: ""
Explanation:
The only distinct string is "b". Since there are fewer than 3 distinct strings, we return an empty string "".

Constraints:
1 <= k <= arr.length <= 1000
1 <= arr[i].length <= 5
arr[i] consists of lowercase English letters.
*/

import java.util.*;

public class KthDistinctString {

    // Approach 1: Using Two HashSets
    public String kthDistinctApproach1(String[] arr, int k) {
        // HashSet to keep track of distinct and duplicate strings
        HashSet<String> distinct = new HashSet<>();
        HashSet<String> duplicate = new HashSet<>();

        // Iterate through the array and update sets
        for (String str : arr) {
            if (distinct.contains(str)) {
                distinct.remove(str);
                duplicate.add(str);
            } else if (!duplicate.contains(str)) {
                distinct.add(str);
            }
        }

        // Iterate through the array to find the kth distinct string
        for (String str : arr) {
            if (distinct.contains(str)) {
                k--;
                if (k == 0) {
                    return str;
                }
            }
        }
        return "";
    }

    // Approach 2: Using a HashMap
    public String kthDistinctApproach2(String[] arr, int k) {
        // HashMap to store the frequency of each string
        Map<String, Integer> map = new HashMap<>();

        // Iterate through the array to populate the map
        for (String str : arr) {
            map.put(str, map.getOrDefault(str, 0) + 1);
        }

        // Iterate through the array again to find the kth distinct string
        for (String str : arr) {
            if (map.get(str) == 1) {
                k--;
                if (k == 0) {
                    return str;
                }
            }
        }
        return "";
    }

    public static void main(String[] args) {
        KthDistinctString solution = new KthDistinctString();

        String[] arr1 = {"d", "b", "c", "b", "c", "a"};
        int k1 = 2;
        System.out.println(solution.kthDistinctApproach1(arr1, k1)); // Output: "a"
        System.out.println(solution.kthDistinctApproach2(arr1, k1)); // Output: "a"

        String[] arr2 = {"aaa", "aa", "a"};
        int k2 = 1;
        System.out.println(solution.kthDistinctApproach1(arr2, k2)); // Output: "aaa"
        System.out.println(solution.kthDistinctApproach2(arr2, k2)); // Output: "aaa"

        String[] arr3 = {"a", "b", "a"};
        int k3 = 3;
        System.out.println(solution.kthDistinctApproach1(arr3, k3)); // Output: ""
        System.out.println(solution.kthDistinctApproach2(arr3, k3)); // Output: ""
    }
}
