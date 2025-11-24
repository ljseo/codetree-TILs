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

    static final int MAX_NUM = 100;
    static int n,m;
    static int[][] grid = new int[MAX_NUM][MAX_NUM];
    static int[][] step = new int[MAX_NUM][MAX_NUM];
    static boolean[][] vis = new boolean[MAX_NUM][MAX_NUM];
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

        queue.add(new Point(0,0));
        vis[0][0] = true;
        step[0][0] = 0;
        step[n-1][m-1] = -1;
        while(!queue.isEmpty()){

            Point currnetPoint = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = currnetPoint.r + dr[i];
                int nc = currnetPoint.c + dc[i];

                if(canGo(nr,nc)){
                    push(nr,nc,step[currnetPoint.r][currnetPoint.c]);
                }
            }
        }

        System.out.println(step[n-1][m-1]);

    }
    static void push(int r, int c, int prevStep){
        step[r][c] = prevStep+1;
        vis[r][c] = true;
        queue.add(new Point(r,c));
    }
    static boolean canGo(int r, int c){
        return inRange(r,c) && !vis[r][c] && grid[r][c] != 0;
    }
    static boolean inRange(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < m;
    }
}