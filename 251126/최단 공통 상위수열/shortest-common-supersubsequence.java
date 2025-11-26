import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        String s = sc.next();
        String t = sc.next();
        
        int n = s.length();
        int m = t.length();
        
        // dp[i][j] = S의 앞 i개 문자와 T의 앞 j개 문자의 최단 공통 상위수열 길이
        int[][] dp = new int[n + 1][m + 1];
        
        // 초기화: 한 문자열이 비어있으면 다른 문자열의 길이가 답
        for (int i = 0; i <= n; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j <= m; j++) {
            dp[0][j] = j;
        }
        
        // DP 테이블 채우기
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // 두 문자가 같으면 한 번만 포함
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 두 문자가 다르면 둘 중 하나를 선택
                    // S의 i번째 문자를 포함하거나 T의 j번째 문자를 포함
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
                }
            }
        }
        
        System.out.println(dp[n][m]);
        sc.close();
    }
}