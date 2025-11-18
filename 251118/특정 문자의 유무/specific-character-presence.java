import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        if(s.contains("ee")) System.out.print("Yes");
        else System.out.print("No");
        if(s.contains("ab")) System.out.print(" Yes");
        else System.out.print(" No");
    }
}