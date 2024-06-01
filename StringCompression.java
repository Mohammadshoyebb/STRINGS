public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbcccddeeef";
        StringBuilder sb = new StringBuilder();
        int count = 1;

        for (int i = 1; i <= s.length(); i++) {
            if (i == s.length() || s.charAt(i - 1) != s.charAt(i)) {
                sb.append(s.charAt(i - 1));
                if (count > 1) {
                    sb.append(count);
                }
                count = 1;
            } else {
                count++;
            }
        }

        System.out.print(sb);
    }
}




/*
public class StringCompression {
    public static void main(String[] args) {
        String s = "aaabbcccddeeef";
        StringBuilder sb = new StringBuilder("");
        int count = 1;
        for(int i = 1;i<s.length();i++){
            
            if(s.charAt(i-1) == s.charAt(i)){
                count++;
            }
            else{
                sb.append(s.charAt(i-1));
                if(count>1){
                sb.append(count+"");
                count = 1;
                }
            }            
        }
        char ch = s.charAt(s.length()-1);
        sb.append(ch);
        if(count>1){
           
            sb.append(count+"");
        }
        System.out.print(sb);
    }
}
*/
