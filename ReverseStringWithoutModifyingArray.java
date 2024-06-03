/**
 * 344. Reverse String
 * Solved
 * Easy
 * 
 * Write a function that reverses a string. The input string is given as an array of characters s.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Input: s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input: s = ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 *
 * Constraints:
 * 1 <= s.length <= 105
 * s[i] is a printable ascii character.
 */

 public class ReverseStringWithoutModifyingArray {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        
        while (left < right) {
            // Swap the characters at the left and right pointers
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            
            // Move the pointers
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        ReverseStringWithoutModifyingArray solution = new ReverseStringWithoutModifyingArray();
        
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        solution.reverseString(s1);
        System.out.println(s1);  // Output: ["o", "l", "l", "e", "h"]
        
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        solution.reverseString(s2);
        System.out.println(s2);  // Output: ["h", "a", "n", "n", "a", "H"]
    }
}

