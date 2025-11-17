import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        String s = sc.next();
        int len = s.length();
        for(int i = len - 1; i>=0; i--){
            if((i + 1) % 2 == 0) sb.append(s.charAt(i));
        }
        System.out.println(sb);
    }
}