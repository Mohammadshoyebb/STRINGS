
    /*
    Given an array of strings nums containing n unique binary strings each of length n,
    return a binary string of length n that does not appear in nums. If there are multiple
    answers, you may return any of them.
    
    Example 1:
    Input: nums = ["01", "10"]
    Output: "11"
    Explanation: "11" does not appear in nums. "00" would also be correct.

    Example 2:
    Input: nums = ["00", "01"]
    Output: "11"
    Explanation: "11" does not appear in nums. "10" would also be correct.

    Example 3:
    Input: nums = ["111", "011", "001"]
    Output: "101"
    Explanation: "101" does not appear in nums. "000", "010", "100", and "110" would also be correct.
    
    Constraints:
    - n == nums.length
    - 1 <= n <= 16
    - nums[i].length == n
    - nums[i] is either '0' or '1'.
    - All the strings of nums are unique.
    */




import java.util.HashSet;
import java.util.Collections;

public class UniqueBinaryStringFinder {


    // First approach
    public String findDifferentBinaryString(String[] nums) {
        int n = nums[0].length();
        HashSet<String> binarySet = new HashSet<>();
        
        // Add all elements from nums to binarySet
        Collections.addAll(binarySet, nums);
        
        // Iterate through all possible binary strings of length n
        for (int i = 0; i < (1 << n); i++) {
            // Generate the binary string for the current number i
            String binaryString = Integer.toBinaryString(i);
            // Pad with leading zeros if necessary
            while (binaryString.length() < n) {
                binaryString = "0" + binaryString;
            }
            
            // Check if binaryString is not in binarySet
            if (!binarySet.contains(binaryString)) {
                return binaryString;
            }
        }
        
        return null; // Should not reach here according to problem statement
    }


  //  ====================================================================================================//
    // Second approach  important approachg
    public String findDifferentBinaryStringAlternate(String[] nums) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return sb.toString();
    }
    
    public static void main(String[] args) {
        UniqueBinaryStringFinder solution = new UniqueBinaryStringFinder();
        
        // Example 1
        String[] nums1 = {"01", "10"};
        String result1 = solution.findDifferentBinaryString(nums1);
        String result1Alt = solution.findDifferentBinaryStringAlternate(nums1);
        System.out.println("Output for Example 1 (Approach 1): " + result1);
        System.out.println("Output for Example 1 (Approach 2): " + result1Alt);
        
        // Example 2
        String[] nums2 = {"00", "01"};
        String result2 = solution.findDifferentBinaryString(nums2);
        String result2Alt = solution.findDifferentBinaryStringAlternate(nums2);
        System.out.println("Output for Example 2 (Approach 1): " + result2);
        System.out.println("Output for Example 2 (Approach 2): " + result2Alt);
        
        // Example 3
        String[] nums3 = {"111", "011", "001"};
        String result3 = solution.findDifferentBinaryString(nums3);
        String result3Alt = solution.findDifferentBinaryStringAlternate(nums3);
        System.out.println("Output for Example 3 (Approach 1): " + result3);
        System.out.println("Output for Example 3 (Approach 2): " + result3Alt);
    }
}