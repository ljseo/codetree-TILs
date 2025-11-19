import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        s = s.substring(1,s.length()) + s.substring(0,1);
        System.out.print(s);
    }
}