public class Palindrome_String{

    public static void palindrome(String str){
      int  start = 0;
       int  end = str.length() - 1;
       while(start<=end){
        if(str.charAt(start) != str.charAt(end)){   //System.out.println("NOT");      
        return;
        }
        else{
            
        }
        start++;
        end--;
       }
      
       System.out.print("String is palindrome");
    } 
    public static void main(String[] args) {
        String str1 = "madam";
        String str2 = "racecar";
        String str3 = " noon";
       palindrome(str1);
    }
}