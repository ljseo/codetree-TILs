import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        char b = sc.next().charAt(0);
        int sum = (int)(a+b);
        int sub = Math.max(a,b) - Math.min(a,b);
        System.out.print(sum + " " + sub);
        
    }
}