import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] soccer = new int[n];
        int[] baseball = new int[n];
        
        for (int i = 0; i < n; i++) {
            soccer[i] = sc.nextInt();
            baseball[i] = sc.nextInt();
        }
        
        // dp[i][j] = i번째 학생까지 고려, 축구팀 j명 선발했을 때 최대 능력 합
        // 음수 사용을 위해 충분히 작은 값으로 초기화
        int[][] dp = new int[n + 1][12];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE / 2);
        }
        dp[0][0] = 0;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= 11; j++) {
                if (dp[i][j] == Integer.MIN_VALUE / 2) continue;
                
                int soccerCount = j;
                int baseballCount = i - j;
                
                // 선택 1: i번째 학생을 축구팀에 선발
                if (soccerCount < 11) {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j + 1], 
                                                  dp[i][j] + soccer[i]);
                }
                
                // 선택 2: i번째 학생을 야구팀에 선발
                if (baseballCount < 9) {
                    dp[i + 1][j] = Math.max(dp[i + 1][j], 
                                             dp[i][j] + baseball[i]);
                }
                
                // 선택 3: i번째 학생을 선발하지 않음
                dp[i + 1][j] = Math.max(dp[i + 1][j], dp[i][j]);
            }
        }
        
        System.out.println(dp[n][11]);
        sc.close();
    }
}