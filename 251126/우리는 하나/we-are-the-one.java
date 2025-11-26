import java.util.*;

public class Main {
    static int n, k, u, d;
    static int[][] grid;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxCities = 0;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        n = sc.nextInt();
        k = sc.nextInt();
        u = sc.nextInt();
        d = sc.nextInt();
        
        grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        
        // 모든 도시 위치를 리스트로 저장
        List<int[]> cities = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cities.add(new int[]{i, j});
            }
        }
        
        // K개의 도시를 선택하는 모든 조합 탐색
        List<int[]> selected = new ArrayList<>();
        combination(cities, selected, 0, 0);
        
        System.out.println(maxCities);
        sc.close();
    }
    
    // K개의 도시를 선택하는 조합 생성
    static void combination(List<int[]> cities, List<int[]> selected, int start, int depth) {
        if (depth == k) {
            // K개를 선택했으면 BFS로 도달 가능한 도시 수 계산
            int reachable = countReachableCities(selected);
            maxCities = Math.max(maxCities, reachable);
            return;
        }
        
        for (int i = start; i < cities.size(); i++) {
            selected.add(cities.get(i));
            combination(cities, selected, i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }
    
    // 선택된 K개의 도시에서 도달 가능한 모든 도시의 수 계산
    static int countReachableCities(List<int[]> startCities) {
        boolean[][] visited = new boolean[n][n];
        Queue<int[]> queue = new LinkedList<>();
        
        // 시작 도시들을 모두 큐에 추가
        for (int[] city : startCities) {
            int x = city[0];
            int y = city[1];
            if (!visited[x][y]) {
                visited[x][y] = true;
                queue.offer(new int[]{x, y});
            }
        }
        
        int count = 0;
        
        // BFS로 도달 가능한 모든 도시 탐색
        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int x = curr[0];
            int y = curr[1];
            count++;
            
            // 상하좌우 4방향 탐색
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                    // 높이 차이가 U 이상 D 이하인 경우만 이동 가능
                    int heightDiff = Math.abs(grid[x][y] - grid[nx][ny]);
                    if (heightDiff >= u && heightDiff <= d) {
                        visited[nx][ny] = true;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
        
        return count;
    }
}