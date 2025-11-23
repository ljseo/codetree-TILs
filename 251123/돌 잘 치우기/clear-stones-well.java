import java.util.*;

class Point {
    int r;
    int c;
    public Point(int r, int c){
        this.r = r;
        this.c = c;
    }
}
public class Main {

    static final int MAX_N = 100;
    static final int DIR_NUM = 4;

    static int n,k,m;
    static int ans = -1;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[][] removedGrid = new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];
    static Point[] startPoints = new Point[MAX_N * MAX_N];

    static int[] dr = new int[]{-1, 1, 0, 0};
    static int[] dc = new int[]{ 0, 0,-1, 1};

    static List<Point> stones = new ArrayList<>();
    static List<Point> selectedStones = new ArrayList<>();
    static Deque<Point> queue = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) stones.add(new Point(i,j));
            }
        }
        for(int i = 0; i < k; i++){
            int r = sc.nextInt() - 1;
            int c = sc.nextInt() - 1;
            startPoints[i] = new Point(r,c);
        }
        selectStones(0);
        System.out.println(ans);
    }
    static void selectStones(int cnt){

        if(selectedStones.size() == m){
            initializeRemovedGrid();
            removeStones();
            bfs();
            ans = Math.max(ans, getMoveCnt());
            return;
        }

        if(cnt >= stones.size()) return;

        Point p = stones.get(cnt);
        selectedStones.add(new Point(p.r, p.c));

        selectStones(cnt+1);
        selectedStones.remove(selectedStones.size()-1);

        selectStones(cnt+1);

    }
    
    static void initializeRemovedGrid(){
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                removedGrid[i][j] = grid[i][j];
            }
        }
    }

    static void removeStones(){
        for(int i = 0; i < selectedStones.size(); i++){
            Point addStone = selectedStones.get(i);
            removedGrid[addStone.r][addStone.c] = 0;
        }
    }

    static void initializeVisited(){
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], false);
        }
    }

    static boolean inRange(int r, int c){
        return 0 <= r && r < n && 0 <= c && c < n;
    }
    static boolean canGo(int r, int c){
        return inRange(r,c) && !visited[r][c] && removedGrid[r][c] != 1;
    }

    static void bfs(){

        initializeVisited();
        for(int i = 0; i < k; i++){
            Point start = startPoints[i];
            queue.add(new Point(start.r, start.c));
            visited[start.r][start.c] = true;
        }

        while(!queue.isEmpty()){
            Point currentPoint = queue.poll();

            for(int i = 0; i < DIR_NUM; i++){
                int nr = currentPoint.r + dr[i];
                int nc = currentPoint.c + dc[i];

                if(canGo(nr, nc)){
                    visited[nr][nc] = true;
                    queue.add(new Point(nr, nc));
                }
            }
        }
    }

    static int getMoveCnt(){
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(visited[i][j]) cnt++;
            }
        }
        return cnt;
    }
}