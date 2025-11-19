import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(s);
        int len = s.length();
        while(len-- > 0){
            s = s.substring(s.length()-1) + s.substring(0,s.length()-1);
            System.out.println(s);
        }
    }
}