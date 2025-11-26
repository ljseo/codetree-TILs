import java.util.*;

public class Main {
    static class Job {
        int start, end, pay;
        
        Job(int start, int end, int pay) {
            this.start = start;
            this.end = end;
            this.pay = pay;
        }
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();
            jobs[i] = new Job(s, e, p);
        }
        
        // 이미 시작 날짜 순으로 정렬되어 입력된다고 가정
        // 만약 아니라면: Arrays.sort(jobs, (a, b) -> a.start - b.start);
        
        // dp[i] = i번째 알바까지 고려했을 때 최대 금액
        int[] dp = new int[n];
        dp[0] = jobs[0].pay;
        
        for (int i = 1; i < n; i++) {
            // 선택 1: i번째 알바를 하지 않는 경우
            dp[i] = dp[i-1];
            
            // 선택 2: i번째 알바를 하는 경우
            int currentPay = jobs[i].pay;
            
            // i번째 알바와 겹치지 않는 가장 최근 알바 찾기
            int lastNonConflict = -1;
            for (int j = i - 1; j >= 0; j--) {
                // 겹치지 않으려면: jobs[j].end < jobs[i].start
                if (jobs[j].end < jobs[i].start) {
                    lastNonConflict = j;
                    break;
                }
            }
            
            // 겹치지 않는 알바가 있으면 그 dp값을 더함
            if (lastNonConflict != -1) {
                currentPay += dp[lastNonConflict];
            }
            
            // 두 선택 중 최댓값
            dp[i] = Math.max(dp[i], currentPay);
        }
        
        System.out.println(dp[n-1]);
        sc.close();
    }
}