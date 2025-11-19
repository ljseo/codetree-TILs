import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.substring(0,2) + s.substring(3,s.length());
        s = s.substring(0,s.length()-2) + s.substring(s.length()-1);
        System.out.println(s);
    }
}