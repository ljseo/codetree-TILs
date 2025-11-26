import java.util.*;

public class Main {
    static int n, k;
    static int[][] grid;
    static int[][] result;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        
        grid = new int[n][n];
        result = new int[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // 입력 받기 및 초기화
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
                
                if (grid[i][j] == 0) {
                    // 빈 칸
                    result[i][j] = -1;
                } else if (grid[i][j] == 2) {
                    // 처음부터 상한 귤
                    result[i][j] = 0;
                    queue.offer(new int[]{i, j, 0}); // x, y, time
                } else {
                    // 아직 상하지 않은 귤
                    result[i][j] = -2;
                }
            }
        }
        
        // 다중 시작점 BFS
        bfs(queue);
        
        // 결과 출력
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(result[i][j]);
                if (j < n - 1) System.out.print(" ");
            }
            System.out.println();
        }
        
        sc.close();
    }
    
    static void bfs(Queue<int[]> queue) {
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            int time = curr[2];
            
            // 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크
                if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                    // 아직 상하지 않은 귤(1)인 경우
                    if (grid[nx][ny] == 1 && result[nx][ny] == -2) {
                        result[nx][ny] = time + 1;
                        queue.offer(new int[]{nx, ny, time + 1});
                    }
                }
            }
        }
    }
}