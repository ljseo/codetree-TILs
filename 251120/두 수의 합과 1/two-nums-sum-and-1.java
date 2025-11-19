import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt() + sc.nextInt();
        String s = Integer.toString(a);
        int len = s.length();
        int cnt = 0;
        for(int i = 0; i < len; i++){
            if(s.charAt(i) == '1') cnt++;
        }
        System.out.println(cnt);
    }
}