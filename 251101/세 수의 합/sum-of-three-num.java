import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextInt();
        long[] arr = new long[n];
        
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            Map<Long, Integer> map = new HashMap<>();

            for(int j = 0; j<i; j++){
                long target = k - arr[i] - arr[j];

                if(map.containsKey(target)){
                    cnt += map.get(target);
                }
                map.put(arr[j], map.getOrDefault(arr[j],0) + 1);
            }
        }
        System.out.println(cnt);

    }
}