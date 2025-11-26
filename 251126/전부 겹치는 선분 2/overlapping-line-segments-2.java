import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[][] segments = new int[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            segments[i][0] = Integer.parseInt(st.nextToken()); // 시작점
            segments[i][1] = Integer.parseInt(st.nextToken()); // 끝점
        }
        
        // 각 선분을 하나씩 제거해보기
        for (int exclude = 0; exclude < N; exclude++) {
            if (canAllOverlap(segments, N, exclude)) {
                System.out.println("Yes");
                return;
            }
        }
        
        System.out.println("No");
    }
    
    // exclude번째 선분을 제외한 나머지가 모두 겹치는지 확인
    static boolean canAllOverlap(int[][] segments, int N, int exclude) {
        int maxStart = Integer.MIN_VALUE; // 모든 시작점의 최댓값
        int minEnd = Integer.MAX_VALUE;   // 모든 끝점의 최솟값
        
        for (int i = 0; i < N; i++) {
            if (i == exclude) continue; // 이 선분은 제외
            
            maxStart = Math.max(maxStart, segments[i][0]);
            minEnd = Math.min(minEnd, segments[i][1]);
        }
        
        // 겹치는 구간이 존재하려면: 최대 시작점 <= 최소 끝점
        return maxStart <= minEnd;
    }
}