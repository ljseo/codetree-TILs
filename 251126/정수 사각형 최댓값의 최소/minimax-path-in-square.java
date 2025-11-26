import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        
        // 입력 받기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // dp[i][j] = (0,0)에서 (i,j)까지의 경로 중 최댓값의 최솟값
        int[][] dp = new int[n][n];
        
        // 초기값: 시작점
        dp[0][0] = grid[0][0];
        
        // 첫 번째 행 초기화 (오른쪽으로만 이동)
        for (int j = 1; j < n; j++) {
            dp[0][j] = Math.max(dp[0][j-1], grid[0][j]);
        }
        
        // 첫 번째 열 초기화 (아래로만 이동)
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i-1][0], grid[i][0]);
        }
        
        // DP 테이블 채우기
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; j++) {
                // 위에서 오는 경우의 최댓값
                int fromTop = Math.max(dp[i-1][j], grid[i][j]);
                // 왼쪽에서 오는 경우의 최댓값
                int fromLeft = Math.max(dp[i][j-1], grid[i][j]);
                
                // 둘 중 최솟값 선택
                dp[i][j] = Math.min(fromTop, fromLeft);
            }
        }
        
        System.out.println(dp[n-1][n-1]);
        sc.close();
    }
}