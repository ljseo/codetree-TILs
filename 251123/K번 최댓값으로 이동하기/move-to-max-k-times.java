import java.util.*;

class Point{
    int row;
    int col;
    public Point(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static final int MAX_N = 100;
    
    static int n,k;

    static int[][] grid =  new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static Deque<Point> queue = new ArrayDeque<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};

    static Point curr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        int startRow = sc.nextInt() - 1;
        int startCol = sc.nextInt() - 1;
        curr = new Point(startRow, startCol);
        
        while(k-->0){
            if(!move()) break;
        }
        System.out.print((curr.row+1) + " " + (curr.col+1));
        
    }

    static List<Point> bfs(Point start){
        
        clearVisited();
        int baseValue = grid[start.row][start.col];
        queue.add(new Point(start.row, start.col));
        visited[start.row][start.col] = true;

        List<Point> reachable = new ArrayList<>();

        while(!queue.isEmpty()){
            
            Point currentPoint = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = currentPoint.row + dr[i];
                int nc = currentPoint.col + dc[i];
                
                if(canGo(nr, nc, baseValue)){
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                    
                    reachable.add(new Point(nr, nc));
                }
            }
        }
        return reachable;
        
    }
    
    static boolean canGo(int row, int col, int value){

        if(!inRange(row, col)) return false;
        if(visited[row][col]) return false;
        if(value <= grid[row][col]) return false;
        return true;
    }

    static boolean inRange(int row, int col){
        return 0 <= row && row < n && 0 <= col && col < n;
    }

    static void clearVisited (){
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], false);
        }
    }

    static Point pickBest(List<Point> list){
        if(list.isEmpty()) return null;

        list.sort((a,b) -> {
            if(grid[a.row][a.col] != grid[b.row][b.col]){
                return grid[b.row][b.col] - grid[a.row][a.col];
            }
            if(a.row != b.row) return a.row - b.row;
            return a.col - b.col;
        });
        return list.get(0);
    }

    static boolean move(){
        List<Point> reachable = bfs(curr);
        Point next = pickBest(reachable);
        if(next == null) return false;
        curr = next;
        return true;
    }
}