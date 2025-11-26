import java.util.Scanner;

public class Main {
    // 알바 정보를 저장할 클래스
    static class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. 입력 받기
        int n = sc.nextInt();
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            int p = sc.nextInt();
            jobs[i] = new Job(s, e, p);
        }

        // 2. DP 배열 초기화
        // dp[i] = i번째 알바를 "마지막으로" 선택했을 때의 최대 이익
        int[] dp = new int[n];

        // 3. DP 수행
        for (int i = 0; i < n; i++) {
            // 기본적으로 i번째 알바 하나만 했을 때의 수익으로 초기화
            dp[i] = jobs[i].profit;

            // i번째 알바 이전에 있는 모든 j번째 알바들을 확인
            for (int j = 0; j < i; j++) {
                // j번째 알바가 끝나는 날짜가 i번째 알바 시작 날짜보다 작아야 함 (겹치지 않는 조건)
                // 문제 조건: 끝난 날과 시작 날이 같아도 겹침 -> strictly less (<) 사용
                if (jobs[j].end < jobs[i].start) {
                    // j번째 알바를 하고 i번째 알바를 하는 것이 이득인지 확인하여 갱신
                    if (dp[j] + jobs[i].profit > dp[i]) {
                        dp[i] = dp[j] + jobs[i].profit;
                    }
                }
            }
        }

        // 4. 결과 출력 (dp 배열 중 최댓값)
        int maxProfit = 0;
        for (int i = 0; i < n; i++) {
            if (dp[i] > maxProfit) {
                maxProfit = dp[i];
            }
        }

        System.out.println(maxProfit);
    }
}