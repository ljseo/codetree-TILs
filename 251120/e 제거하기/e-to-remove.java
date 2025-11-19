import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int idx = s.indexOf('e');
        s = s.substring(0,idx) + s.substring(idx+1); 
        System.out.print(s);
    }
}