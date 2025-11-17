import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int mn = 21;
        int mx = -1;
        String s = sc.next();
        mn = Math.min(mn, s.length());
        mx = Math.max(mx, s.length());
        s = sc.next();
        mn = Math.min(mn, s.length());
        mx = Math.max(mx, s.length());
        s = sc.next();
        mn = Math.min(mn, s.length());
        mx = Math.max(mx, s.length());

        System.out.print(mx - mn);
    }
}