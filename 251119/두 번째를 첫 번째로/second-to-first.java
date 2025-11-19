import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c1 = s.charAt(0);
        char c2 = s.charAt(1);
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == c2) {
                s = s.substring(0,i) + c1 + s.substring(i+1);
            }
        }
        System.out.print(s);
        
    }
}