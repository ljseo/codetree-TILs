import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String,Integer> map = new HashMap<>();
        String[] arr = new String[n];
        int mx = -1;
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            int cnt = map.getOrDefault(str, 0);
            cnt++;
            map.put(str, cnt);
            mx = Math.max(mx, cnt);
        }
        System.out.println(mx);
    }
}