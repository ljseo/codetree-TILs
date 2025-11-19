import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String a = sc.next();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            String b = sc.next();
            if(b.equals(a)) cnt++;
        }
        System.out.print(cnt);
    }
}