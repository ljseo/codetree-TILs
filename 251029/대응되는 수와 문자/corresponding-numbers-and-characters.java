import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String[] words = new String[n + 1];
        Map<String,Integer> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            words[i] = sc.next();
            map.put(words[i], i);
        }
        for(int j = 0; j<m; j++){
            String value = sc.next();
            if(value.charAt(0) >= 'a' && value.charAt(0) <= 'z'){
                System.out.println(map.get(value));
            }
            else{
                System.out.println(words[Integer.parseInt(value)]);
            }
        }
    }
}