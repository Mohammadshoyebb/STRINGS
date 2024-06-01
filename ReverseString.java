public class ReverseString {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        char ch[] = new char[right+1];

        for(int i=right;i>=0;i--){
            ch[right-i] = s[i];
        }
        // // Swap characters from both ends until left pointer crosses right pointer
        // while (left < right) {
        //     char temp = s[left];
        //     s[left] = s[right];
        //     s[right] = temp;
        //     left++;
        //     right--;
        
    }
    
    public static void main(String[] args) {
        ReverseString reverseString = new ReverseString();
        
        // Example 1
        char[] s1 = {'h', 'e', 'l', 'l', 'o'};
        reverseString.reverseString(s1);
        System.out.println((s1)); // Output: ['o', 'l', 'l', 'e', 'h']
        
        // Example 2
        char[] s2 = {'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString.reverseString(s2);
        System.out.println((s2)); // Output: ['h', 'a', 'n', 'n', 'a', 'H']
    }
}

