
    /*
    Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.
    If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters,
    then reverse the first k characters and leave the other as original.
    
    Example 1:
    Input: s = "abcdefg", k = 2
    Output: "bacdfeg"
    
    Example 2:
    Input: s = "abcd", k = 2
    Output: "bacd"
    
    Additional Examples:
    Example 3:
    Input: s = "abcdefgh", k = 3
    Output: "cbadefhg"
    
    Example 4:
    Input: s = "abcdefghi", k = 4
    Output: "dcbaefihg"
    
    Example 5:
    Input: s = "abcdefghij", k = 3
    Output: "cbadefhgij"
    
    Constraints:
    - 1 <= s.length <= 104
    - s consists of only lowercase English letters.
    - 1 <= k <= 104
    */
    
    // Method to reverse a portion of char array from index start to end

    public class ReverseStringII {
    public void reverse(char[] arr, int start, int end) {
        while (start < end) {
            char temp = arr[end];
            arr[end] = arr[start];
            arr[start] = temp;
            start++;
            end--;
        }
    }

    // Main method to implement the logic as per the problem statement
    public String reverseStr(String s, int k) {
        int n = s.length();
        char[] charArray = s.toCharArray();
        int i = 0;
        
        // Iterate through the string in increments of 2k
        while (i < n) {
            // Determine the ending index of the segment to be reversed
            int j = Math.min(i + k - 1, n - 1);
            // Reverse the characters from index i to j
            reverse(charArray, i, j);
            // Move to the next segment starting after 2k characters
            i += 2 * k;
        }
        
        // Convert the modified char array back to string and return
        return new String(charArray);
    }

    // Main method to test the reverseStr function with examples
    public static void main(String[] args) {
        ReverseStringII solution = new ReverseStringII();

        // Example 1
        String s1 = "abcdefg";
        int k1 = 2;
        System.out.println("Input: s = \"" + s1 + "\", k = " + k1);
        System.out.println("Output: \"" + solution.reverseStr(s1, k1) + "\"");

        // Example 2
        String s2 = "abcd";
        int k2 = 2;
        System.out.println("\nInput: s = \"" + s2 + "\", k = " + k2);
        System.out.println("Output: \"" + solution.reverseStr(s2, k2) + "\"");

        // Additional Examples
        String s3 = "abcdefgh";
        int k3 = 3;
        System.out.println("\nInput: s = \"" + s3 + "\", k = " + k3);
        System.out.println("Output: \"" + solution.reverseStr(s3, k3) + "\"");

        String s4 = "abcdefghi";
        int k4 = 4;
        System.out.println("\nInput: s = \"" + s4 + "\", k = " + k4);
        System.out.println("Output: \"" + solution.reverseStr(s4, k4) + "\"");

        String s5 = "abcdefghij";
        int k5 = 3;
        System.out.println("\nInput: s = \"" + s5 + "\", k = " + k5);
        System.out.println("Output: \"" + solution.reverseStr(s5, k5) + "\"");
    }
}

