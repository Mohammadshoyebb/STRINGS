public class Capitalize {
    public static void toUpperCase(String s){
        StringBuilder sb = new StringBuilder("");
        char ch = Character.toUpperCase(s.charAt(0));
        sb.append(ch);
        for(int i=1;i<s.length();i++){
            if(s.charAt(i-1) == ' '){
                ch = Character.toUpperCase(s.charAt(i));
                sb.append(ch);
            }
            else{
                ch = s.charAt(i);
                sb.append(ch);
            }
        }
        System.out.println(sb);

    }
    public static void main(String[] args) {
        String s = "hello my name is mohd shoyeb sheakh  ";
        toUpperCase(s);
    }
}
