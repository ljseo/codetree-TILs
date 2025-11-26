import java.util.Scanner;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[] used;
    static int maxMinValue = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        grid = new int[n][n];
        used = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // 첫 번째 행부터 시작하여 순열 생성
        selectColumns(0, Integer.MAX_VALUE);
        
        System.out.println(maxMinValue);
        
        sc.close();
    }
    
    // 백트래킹을 이용한 순열 생성
    // row: 현재 행, currentMin: 지금까지 선택된 수들의 최솟값
    static void selectColumns(int row, int currentMin) {
        // 모든 행에서 선택을 완료한 경우
        if (row == n) {
            maxMinValue = Math.max(maxMinValue, currentMin);
            return;
        }
        
        // 현재 행에서 각 열을 선택해보기
        for (int col = 0; col < n; col++) {
            // 이미 사용된 열은 건너뛰기
            if (used[col]) continue;
            
            // 열 선택
            used[col] = true;
            int newMin = Math.min(currentMin, grid[row][col]);
            
            // 가지치기: 현재 최솟값이 이미 찾은 답보다 작거나 같으면 탐색 중단
            if (newMin > maxMinValue) {
                selectColumns(row + 1, newMin);
            }
            
            // 열 선택 해제 (백트래킹)
            used[col] = false;
        }
    }
}