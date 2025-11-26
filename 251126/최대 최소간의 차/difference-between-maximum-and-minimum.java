import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        int[] nums = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        
        // 배열 정렬
        Arrays.sort(nums);
        
        int minCost = Integer.MAX_VALUE;
        
        // 가능한 모든 최소값 L을 시도
        // 최적화: L은 최소한 (최소값 - K)부터, 최대 (최대값)까지만 고려
        int minNum = nums[0];
        int maxNum = nums[N - 1];
        
        for (int L = Math.max(1, minNum - K); L <= maxNum; L++) {
            int R = L + K; // 최대값
            int cost = 0;
            
            // 각 수를 [L, R] 범위로 이동
            for (int num : nums) {
                if (num < L) {
                    cost += L - num; // L로 이동
                } else if (num > R) {
                    cost += num - R; // R로 이동
                }
                // L <= num <= R이면 비용 0
            }
            
            minCost = Math.min(minCost, cost);
        }
        
        System.out.println(minCost);
    }
}