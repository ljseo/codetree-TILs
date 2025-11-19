import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = s1.substring(0,2);
        System.out.print(s1 + s2.substring(2,s2.length()));
    }
}