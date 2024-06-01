import java.lang.Math;
public class ShortestPath_North_South_East_West {
    public static double shortestDirection(String s){
        int x = 0,y=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='N'){
                y+=1;
            }
            else if(s.charAt(i)=='E'){
                x+=1;
            }
            else if(s.charAt(i)=='W'){
                x-=1;
            }
            else{
                y-=1;
            }
        }
        double ans = Math.sqrt(Math.pow(x,2)+Math.pow(y,2));
        return ans;

    }
    public static void main(String[] args) {
        String s = "WNEENESENNN";
        double ans = shortestDirection(s);
        System.out.println(ans);
    }
}
