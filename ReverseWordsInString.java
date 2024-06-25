/*
    Given a string s, reverse the order of characters in each word within a sentence
    while still preserving whitespace and initial word order.

    Example:
    Input: s = "Let's take LeetCode contest"
    Output: "s'teL ekat edoCteeL tsetnoc"

    Constraints:
    - 1 <= s.length <= 5 * 10^4
    - s contains printable ASCII characters.
    - s does not contain any leading or trailing spaces.
    - There is at least one word in s.
    - All the words in s are separated by a single space.
*/

public class ReverseWordsInString {

    public static String reverseWords(String s) {
        // Split the string into words based on single space
        String[] words = s.split(" ");
        StringBuilder result = new StringBuilder();
        
        // Iterate through each word
        for (String word : words) {
            // Reverse each word and append to result
            result.append(reverseWord(word)).append(" ");
        }
        
        // Remove the last extra space and return the result
        return result.toString().trim();
    }
    
    private static String reverseWord(String word) {
        char[] charArray = word.toCharArray();
        int left = 0;
        int right = charArray.length - 1;
        
        // Swap characters from both ends towards the center
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        
        // Return the reversed word as a string
        return new String(charArray);
    }
    
    public static void main(String[] args) {
        // Test cases
        String s1 = "Let's take LeetCode contest";
        System.out.println("Input: " + s1);
        System.out.println("Output: " + reverseWords(s1)); // Expected output: "s'teL ekat edoCteeL tsetnoc"
        
        String s2 = "Mr Ding";
        System.out.println("\nInput: " + s2);
        System.out.println("Output: " + reverseWords(s2)); // Expected output: "rM gniD"
    }
}

