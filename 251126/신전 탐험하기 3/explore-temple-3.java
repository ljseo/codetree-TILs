import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        
        int[][] treasure = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                treasure[i][j] = sc.nextInt();
            }
        }
        
        // dp[i][j] = i층에서 j번 방을 선택했을 때 최대 보물 개수
        int[][] dp = new int[n][m];
        
        // 1층 초기화
        for (int j = 0; j < m; j++) {
            dp[0][j] = treasure[0][j];
        }
        
        // 2층부터 N층까지 DP
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // i층에서 j번 방 선택
                // (i-1)층에서 j번이 아닌 모든 방 중 최댓값 찾기
                int maxPrev = 0;
                for (int k = 0; k < m; k++) {
                    if (k != j) {
                        maxPrev = Math.max(maxPrev, dp[i-1][k]);
                    }
                }
                dp[i][j] = treasure[i][j] + maxPrev;
            }
        }
        
        // N층에서의 최댓값 찾기
        int answer = 0;
        for (int j = 0; j < m; j++) {
            answer = Math.max(answer, dp[n-1][j]);
        }
        
        System.out.println(answer);
        sc.close();
    }
}