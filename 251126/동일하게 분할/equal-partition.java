import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] nums = new int[n];
        int totalSum = 0;
        
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
            totalSum += nums[i];
        }
        
        // 전체 합이 홀수면 불가능
        if (totalSum % 2 == 1) {
            System.out.println("No");
            sc.close();
            return;
        }
        
        int target = totalSum / 2;
        
        // dp[i][j] = i번째 수까지 고려했을 때, 합이 j를 만들 수 있는가?
        boolean[][] dp = new boolean[n + 1][target + 1];
        
        // 초기값: 0개의 수로 합 0을 만들 수 있음
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        
        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            
            for (int j = 0; j <= target; j++) {
                // 선택 1: i번째 수를 선택하지 않음
                dp[i][j] = dp[i - 1][j];
                
                // 선택 2: i번째 수를 선택함
                if (j >= num && dp[i - 1][j - num]) {
                    dp[i][j] = true;
                }
            }
        }
        
        if (dp[n][target]) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        
        sc.close();
    }
}