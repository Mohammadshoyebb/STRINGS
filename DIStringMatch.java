/*
 * 942. DI String Match
Solved
Easy
Topics
Companies
A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:

s[i] == 'I' if perm[i] < perm[i + 1], and
s[i] == 'D' if perm[i] > perm[i + 1].
Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.

 

Example 1:

Input: s = "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: s = "III"
Output: [0,1,2,3]
Example 3:

Input: s = "DDI"
Output: [3,2,0,1]
 

Constraints:

1 <= s.length <= 105
s[i] is either 'I' or 'D'.
 */




import java.util.*;
public class DIStringMatch {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] perm = new int[n + 1];
        int min = 0, max = n;

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                perm[i] = min++;
            } else {
                perm[i] = max--;
            }
        }

        perm[n] = min; // or max, both are equal

        return perm;
    }

    public static void main(String[] args) {
        DIStringMatch solution = new DIStringMatch();

        // Example 1
        String s1 = "IDID";
        int[] result1 = solution.diStringMatch(s1);
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\"");
        System.out.println("Output: " + Arrays.toString(result1));

        // Example 2
        String s2 = "III";
        int[] result2 = solution.diStringMatch(s2);
        System.out.println("\nExample 2:");
        System.out.println("Input: s = \"" + s2 + "\"");
        System.out.println("Output: " + Arrays.toString(result2));

        // Example 3
        String s3 = "DDI";
        int[] result3 = solution.diStringMatch(s3);
        System.out.println("\nExample 3:");
        System.out.println("Input: s = \"" + s3 + "\"");
        System.out.println("Output: " + Arrays.toString(result3));
    }
}


//========================================Another Method============================================
/*
 * class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int arr[] = new int[n+1];
        int start = 0;
        int end = n;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='I'){
                arr[i] = start++;
            }
            else{
                arr[i] = end--;
            }
        }
        if(s.charAt(n-1)=='D'){
            arr[n] = end--;
        }else{
            arr[n] = start++;
        }
        return arr;
    }
}
 */
