import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char c = sc.next().charAt(0);
        System.out.print(s.indexOf(c) == -1 ? "No" : s.indexOf(c));

    }
}