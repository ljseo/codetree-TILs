import java.util.*;

class Point {
    int row;
    int col;
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n,k;
    static int[][] grid = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{ 0, 0,-1, 1};
    

    static Deque<Point> queue = new ArrayDeque<>();
    static Point[] startPoints = new Point[MAX_N * MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < k; i++){
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            if(!visited[r][c]) bfs(new Point(r,c));
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }
    static void bfs(Point startPoint){
        
        queue.add(startPoint);
        visited[startPoint.row][startPoint.col] = true;
        while(!queue.isEmpty()){

            Point currentPoint = queue.poll();

            for(int i = 0; i < DIR_NUM; i++){
                int nr = currentPoint.row + dr[i];
                int nc = currentPoint.col + dc[i];

                if(canGo(nr, nc)){
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                }
            }
        }
    }
    static boolean canGo(int r, int c){
        if(!inRange(r,c)) return false;
        if(visited[r][c]) return false;
        if(grid[r][c] == 1) return false;
        return true;
    }
    static boolean inRange(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < n;
    }
}