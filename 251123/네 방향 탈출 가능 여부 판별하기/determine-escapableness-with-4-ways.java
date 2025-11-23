import java.util.*;

class Point {
    int row;
    int col;
    public Point (int row, int col){
        this.row = row;
        this.col = col;
    }
}
public class Main {

    static final int MAX_N = 100;
    static final int MAX_M = 100;
    static final int DIR_NUM = 4;
    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{ 0, 0,-1, 1};
    static int n,m;
    static int[][] grid = new int[MAX_N][MAX_M];
    static boolean[][] vis = new boolean[MAX_N][MAX_M];
    static Deque<Point> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        queue.add(new Point(0,0));
        vis[0][0] = true;

        while(!queue.isEmpty()){
            
            Point currentPoint = queue.poll();
            
            if(currentPoint.row == n-1 && currentPoint.col == m-1){
                System.out.println(1);
                return;
            }

            for(int i = 0; i < DIR_NUM; i++){
                int nr = currentPoint.row + dr[i];
                int nc = currentPoint.col + dc[i];

                if(canGo(nr, nc)){
                    vis[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                }

            }

        }
        System.out.println(0);
        return;
    }
    static boolean canGo(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < m && !vis[r][c] && grid[r][c] != 0;
    }
}