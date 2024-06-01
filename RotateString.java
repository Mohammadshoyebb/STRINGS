public class RotateString {
    public boolean rotateString(String s, String goal) {
        return (s.length()==goal.length() && (s+s).contains(goal));
    }


//==================ANOTHER METHOD===============================================================

    //public boolean rotateString(String s, String goal) {
        // // Check if lengths of s and goal are equal
        // if (s.length() != goal.length()) {
        //     return false;
        // }

        // // Iterate through all possible rotations of s
        // for (int i = 0; i < s.length(); i++) {
        //     // Rotate s by shifting the leftmost character to the rightmost position
        //     s = s.substring(1) + s.charAt(0);

        //     // Check if the rotated string matches the goal string
        //     if (s.equals(goal)) {
        //         return true;
        //     }
        // }

        // // If no rotation matches the goal string, return false
        // return false;
    // }
    

    public static void main(String[] args) {
        RotateString solution = new RotateString();

        // Example 1
        String s1 = "abcde";
        String goal1 = "cdeab";
        System.out.println(solution.rotateString(s1, goal1)); // Output: true

        // Example 2
        String s2 = "abcde";
        String goal2 = "abced";
        System.out.println(solution.rotateString(s2, goal2)); // Output: false
    }
}
