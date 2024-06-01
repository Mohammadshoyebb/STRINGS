/* */




public class ShuffleString {
    public static String restoreString(String s, int[] indices) {
        char[] shuffled = new char[s.length()]; // Create an array to store the shuffled characters
        
        for (int i = 0; i < s.length(); i++) {
            shuffled[indices[i]] = s.charAt(i); // Place each character of s at its corresponding index in shuffled
        }
        
        return new String(shuffled); // Convert the char array to a string and return
    }

    public static void main(String[] args) {
        // Example 1
        String s1 = "codeleet";
        int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3};
        String result1 = restoreString(s1, indices1);
        System.out.println("Example 1:");
        System.out.println("Input: s = \"" + s1 + "\", indices = " + (indices1));
        System.out.println("Output: \"" + result1 + "\"");

        // Example 2
        String s2 = "abc";
        int[] indices2 = {0, 1, 2};
        String result2 = restoreString(s2, indices2);
        System.out.println("\nExample 2:");
        System.out.println("Input: s = \"" + s2 + "\", indices = " + (indices2));
        System.out.println("Output: \"" + result2 + "\"");
    }
}






//=====================================================ANOTHER METHOD USING HASHMAP=======================================


// import java.util.HashMap;

// public class ShuffleString {
//     public static String restoreString(String s, int[] indices) {
//         HashMap<Integer, Character> map = new HashMap<>();
        
//         // Populate the HashMap with indices and characters
//         for (int i = 0; i < s.length(); i++) {
//             map.put(indices[i], s.charAt(i));
//         }
        
//         // Build the shuffled string using characters from the HashMap
//         StringBuilder sb = new StringBuilder();
//         for (int i = 0; i < s.length(); i++) {
//             sb.append(map.get(i));
//         }
        
//         return sb.toString();
//     }

//     public static void main(String[] args) {
//         // Example 1
//         String s1 = "codeleet";
//         int[] indices1 = {4, 5, 6, 7, 0, 2, 1, 3};
//         String result1 = restoreString(s1, indices1);
//         System.out.println("Example 1:");
//         System.out.println("Input: s = \"" + s1 + "\", indices = " + Arrays.toString(indices1));
//         System.out.println("Output: \"" + result1 + "\"");

//         // Example 2
//         String s2 = "abc";
//         int[] indices2 = {0, 1, 2};
//         String result2 = restoreString(s2, indices2);
//         System.out.println("\nExample 2:");
//         System.out.println("Input: s = \"" + s2 + "\", indices = " + Arrays.toString(indices2));
//         System.out.println("Output: \"" + result2 + "\"");
//     }
// }



// Explanation of code


/*
 * Shuffle String
 
Approach 1: Using Array
Working:
In this approach, we create an array shuffled to store the shuffled characters.
We iterate through the characters of the input string s.
For each character at index i, we place it at the index specified by indices[i] in the shuffled array.
Finally, we convert the shuffled array to a string and return it.
Complexity:
Time Complexity: O(n) where n is the length of the input string s. We iterate through the string once to rearrange its characters.
Space Complexity: O(n) for the shuffled array.

Approach 2: Using HashMap
Working:
In this approach, we use a HashMap to map each index to its corresponding character in the string s.
We populate the HashMap by iterating through the characters of s and putting each character at its corresponding index in the HashMap.
We then iterate through the indices array and build the shuffled string using characters retrieved from the HashMap.
Finally, we return the shuffled string.

Complexity:
Time Complexity: O(n) where n is the length of the input string s. We iterate through the string once to populate the HashMap and once again to build the shuffled string.
Space Complexity: O(n) for the HashMap and the StringBuilder.
 */