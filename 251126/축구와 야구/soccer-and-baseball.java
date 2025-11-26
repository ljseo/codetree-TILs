import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        
        int[][] students = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            students[i][0] = Integer.parseInt(st.nextToken()); // 축구
            students[i][1] = Integer.parseInt(st.nextToken()); // 야구
        }
        
        // dp[j][k] = 축구팀 j명, 야구팀 k명 선발했을 때 최대 능력합
        // 공간 최적화: 이전 상태만 필요
        int[][] dp = new int[12][10];
        
        // -1로 초기화 (불가능한 상태 표시)
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        dp[0][0] = 0;
        
        for (int i = 0; i < N; i++) {
            int soccer = students[i][0];
            int baseball = students[i][1];
            
            // 역순으로 순회해야 같은 학생 중복 선발 방지
            for (int j = Math.min(11, i + 1); j >= 0; j--) {
                for (int k = Math.min(9, i + 1 - j); k >= 0; k--) {
                    if (dp[j][k] == Integer.MIN_VALUE) continue;
                    
                    // 이 학생을 축구팀에 넣는 경우
                    if (j < 11) {
                        dp[j + 1][k] = Math.max(dp[j + 1][k], dp[j][k] + soccer);
                    }
                    
                    // 이 학생을 야구팀에 넣는 경우
                    if (k < 9) {
                        dp[j][k + 1] = Math.max(dp[j][k + 1], dp[j][k] + baseball);
                    }
                    
                    // 선발하지 않는 경우는 dp[j][k] 그대로 유지
                }
            }
        }
        
        System.out.println(dp[11][9]);
    }
}