import java.util.Scanner;

public class Main {
    static int n, m;
    static int[][] points;
    static int minMaxDist = Integer.MAX_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        m = sc.nextInt();
        
        points = new int[n][2];
        for (int i = 0; i < n; i++) {
            points[i][0] = sc.nextInt();
            points[i][1] = sc.nextInt();
        }
        
        // M개의 점을 선택하는 모든 조합 탐색
        int[] selected = new int[m];
        selectPoints(0, 0, selected);
        
        System.out.println(minMaxDist);
        
        sc.close();
    }
    
    // 조합을 생성하는 함수
    static void selectPoints(int start, int count, int[] selected) {
        // M개를 모두 선택한 경우
        if (count == m) {
            // 선택된 점들 중 최대 거리 계산
            int maxDist = getMaxDistance(selected);
            minMaxDist = Math.min(minMaxDist, maxDist);
            return;
        }
        
        // 조합 생성
        for (int i = start; i < n; i++) {
            selected[count] = i;
            selectPoints(i + 1, count + 1, selected);
        }
    }
    
    // 선택된 점들 중 최대 거리의 제곱 계산
    static int getMaxDistance(int[] selected) {
        int maxDist = 0;
        
        // 선택된 모든 점 쌍에 대해 거리 계산
        for (int i = 0; i < m; i++) {
            for (int j = i + 1; j < m; j++) {
                int idx1 = selected[i];
                int idx2 = selected[j];
                
                int dx = points[idx1][0] - points[idx2][0];
                int dy = points[idx1][1] - points[idx2][1];
                int distSquared = dx * dx + dy * dy;
                
                maxDist = Math.max(maxDist, distSquared);
            }
        }
        
        return maxDist;
    }
}