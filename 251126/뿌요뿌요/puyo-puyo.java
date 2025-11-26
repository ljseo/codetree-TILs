import java.util.*;

public class Main {
    static int n;
    static int[][] grid;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        grid = new int[n][n];
        visited = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        int burstCount = 0;  // 터지는 블럭 수
        int maxBlockSize = 0;  // 최대 블럭 크기
        
        // 모든 칸을 순회하며 블럭 찾기
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    int blockSize = bfs(i, j);
                    
                    // 최대 블럭 크기 갱신
                    maxBlockSize = Math.max(maxBlockSize, blockSize);
                    
                    // 4개 이상이면 터지는 블럭
                    if (blockSize >= 4) {
                        burstCount++;
                    }
                }
            }
        }
        
        System.out.println(burstCount + " " + maxBlockSize);
        sc.close();
    }
    
    // BFS로 연결된 블럭의 크기 계산
    static int bfs(int startX, int startY) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        int value = grid[startX][startY];
        int count = 1;
        
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            
            // 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                // 범위 체크 및 방문 여부 확인
                if (nx >= 0 && nx < n && ny >= 0 && ny < n 
                    && !visited[nx][ny] && grid[nx][ny] == value) {
                    
                    visited[nx][ny] = true;
                    queue.offer(new int[]{nx, ny});
                    count++;
                }
            }
        }
        
        return count;
    }
}