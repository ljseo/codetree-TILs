import java.util.*;

class Point{
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}

public class Main {

    static final int MAX_NUM = 200;

    static int n,m;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static boolean[][] visited = new boolean[MAX_NUM][MAX_NUM];
    static int[][] cnt = new int[MAX_NUM][MAX_NUM];
    
    static Deque<Point> queue = new ArrayDeque<>();

    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{ 0, 0,-1, 1};
    

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        addIce();
        while(!queue.isEmpty()){
            Point p = queue.poll();
            
            for(int i = 0; i < 4; i++){
                int nr = p.r + dr[i];
                int nc = p.c + dc[i];
                if(isRange(nr,nc) && !visited[nr][nc] && grid[nr][nc] == 1){
                    grid[nr][nc] = 0;
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    cnt[nr][nc] = cnt[p.r][p.c] + 1;
                }
            }
        }

        int mx = -1;
        int mxCnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(cnt[i][j] > mx){
                    mx = cnt[i][j];
                    mxCnt = 1;
                }
                else if(cnt[i][j] == mx) {
                    mxCnt++;
                }
            }
        }
        System.out.println(mx + " " + mxCnt);
    }

    static void addIce(){

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(i == 0 || i == n - 1 || j == 0 || j == m-1) {
                    queue.add(new Point(i,j));
                    visited[i][j] = true;
                    cnt[i][j] = 0;
                }
                else if(grid[i][j] == 0 && !isSurround(i,j)) {
                    queue.add(new Point(i,j));
                    visited[i][j] = true;
                    cnt[i][j] = 0;
                }
            }

        }
    }

    static boolean isSurround(int row, int col){
        
        Deque<Point> q = new ArrayDeque<>();
        boolean[][] vis = new boolean[MAX_NUM][MAX_NUM];
        q.add(new Point(row, col));
        vis[row][col] = true;
        while(!q.isEmpty()){
            Point current = q.poll();

            if(current.r == 0 || current.r == n-1 || current.c == 0 || current.c == m-1) return false;

            for(int i = 0; i < 4; i++){
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                if(!isRange(nr, nc) || vis[nr][nc]) continue;
                if(grid[nr][nc] == 0) {
                    q.add(new Point(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        return true;
    }

    static boolean isRange(int row, int col){
        return 0 <= row && row < n && 0 <= col && col < m;
    }
}