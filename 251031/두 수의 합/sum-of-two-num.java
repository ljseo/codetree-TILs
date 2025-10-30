import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Map<Long,Integer> map = new HashMap<>();
        long ans = 0;
        for(int i = 0; i<n; i++){
            long key = k - arr[i];

            if(map.containsKey(key)){
                ans += map.get(key);
            }
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        System.out.print(ans);
    }
}