import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim());
        
        int[][] jobs = new int[n][3]; // [시작, 끝, 급여]
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            jobs[i][0] = Integer.parseInt(st.nextToken()); // 시작
            jobs[i][1] = Integer.parseInt(st.nextToken()); // 끝
            jobs[i][2] = Integer.parseInt(st.nextToken()); // 급여
        }
        
        // 시작일 기준 정렬 (이미 정렬되어 있다고 했지만 안전하게)
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);
        
        // dp[i] = i번째 알바까지 고려했을 때 최대 수익
        long[] dp = new long[n];
        
        // 끝나는 시간 배열 (이분탐색용)
        int[] endTimes = new int[n];
        for (int i = 0; i < n; i++) {
            endTimes[i] = jobs[i][1];
        }
        
        dp[0] = jobs[0][2];
        
        for (int i = 1; i < n; i++) {
            int startTime = jobs[i][0];
            int profit = jobs[i][2];
            
            // i번째 알바를 하지 않는 경우
            dp[i] = dp[i - 1];
            
            // i번째 알바를 하는 경우
            // endTime < startTime 인 가장 마지막 알바 찾기
            int prevIdx = findLastNonOverlapping(jobs, i, startTime);
            
            long include = profit;
            if (prevIdx != -1) {
                include += dp[prevIdx];
            }
            
            dp[i] = Math.max(dp[i], include);
        }
        
        System.out.println(dp[n - 1]);
    }
    
    // endTime < startTime 조건을 만족하는 가장 큰 인덱스 찾기
    static int findLastNonOverlapping(int[][] jobs, int currentIdx, int startTime) {
        int left = 0;
        int right = currentIdx - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            
            if (jobs[mid][1] < startTime) {
                // 겹치지 않음 -> 더 오른쪽 탐색
                result = mid;
                left = mid + 1;
            } else {
                // 겹침 -> 더 왼쪽 탐색
                right = mid - 1;
            }
        }
        
        return result;
    }
}