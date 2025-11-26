import java.util.*;

public class Main {
    static final int MOD = 10007;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        // dp[i] = 2×i 사각형을 채우는 방법의 수
        int[] dp = new int[n + 1];
        
        // 초기값 설정
        dp[0] = 1;  // 아무것도 안 채우는 경우
        if (n >= 1) {
            dp[1] = 1;  // 2×1: 1×2 타일 2개 세로로
        }
        
        // 점화식: dp[i] = dp[i-1] + 2 * dp[i-2]
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i-1] + 2 * dp[i-2]) % MOD;
        }
        
        System.out.println(dp[n]);
        sc.close();
    }
}