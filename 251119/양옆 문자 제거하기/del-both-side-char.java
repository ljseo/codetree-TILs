import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.substring(0,1) + s.substring(2,s.length());
        // System.out.println(s);
        s = s.substring(0,s.length()-2) + s.substring(s.length()-1);
        System.out.println(s);
    }
}