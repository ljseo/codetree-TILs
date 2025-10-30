import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        Map<Long,Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            map.put(Long.valueOf(arr[i]), map.getOrDefault(Long.valueOf(arr[i]), 0) + 1);
        }
        long sum = 0;

        for(Long key : map.keySet()){
            long otherKey = k - key;
            if(map.containsKey(otherKey)){
                if(otherKey == key) {
                    sum += (map.get(otherKey) - 1) * map.get(key);    
                }
                else sum += map.get(otherKey) * map.get(key);
            }
            // System.out.println(key + " " + map.get(key) + " " + value);
        }
        System.out.print(sum/2);
        
    }
}