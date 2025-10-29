import java.util.Scanner;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
        }
        Map<Integer, Integer> map = new HashMap<>();

        for(int a : arr){
            int val = map.getOrDefault(a, 0);
            map.put(a, val+1);
        }
        for(int q : queries){
            sb.append(map.getOrDefault(q,0)).append(" ");
        }
        System.out.println(sb);
    
    }
}