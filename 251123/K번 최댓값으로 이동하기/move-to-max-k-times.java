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
    static int startRow,startCol;

    static int[][] grid =  new int[MAX_N][MAX_N];
    static boolean[][] visited = new boolean[MAX_N][MAX_N];

    static Deque<Point> queue = new ArrayDeque<>();

    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        startRow = sc.nextInt() - 1;
        startCol = sc.nextInt() - 1;

        
        while(k-->0){
            bfs(startRow, startCol);
        }
        startRow++;
        startCol++;
        System.out.println(startRow + " " + startCol);
        
    }

    static void bfs(int row, int col){
        
        
        for(int i = 0; i < n; i++){
            Arrays.fill(visited[i], false);
        }
        queue.add(new Point(row, col));
        visited[row][col] = true;
        int standValue = grid[row][col];
        int mxRow = -1;
        int mxCol = -1;
        int mx = -1;
        while(!queue.isEmpty()){
            
            Point currentPoint = queue.poll();

            for(int i = 0; i < 4; i++){
                int nr = currentPoint.row + dr[i];
                int nc = currentPoint.col + dc[i];

                if(isValid(nr, nc, standValue)){
                    if(grid[nr][nc] > mx){
                        mx = grid[nr][nc];
                        mxRow = nr;
                        mxCol = nc;
                    }
                    else if(grid[nr][nc] == mx){
                        if(nr < mxRow){
                            mxRow = nr;
                            mxCol = nc;
                        }
                        else if(nr == mxRow && nc < mxCol){
                            mxCol = nc;
                        }
                    }
                    queue.add(new Point(nr, nc));
                    visited[nr][nc] = true;
                }
            }
        }
        if(mxRow != -1 && mxCol != -1){
            startRow = mxRow;
            startCol = mxCol;
        }
        
    }
    
    static boolean isValid(int row, int col, int value){

        if(!inRange(row, col)) return false;
        if(visited[row][col]) return false;
        if(value <= grid[row][col]) return false;
        return true;
    }

    static boolean inRange(int row, int col){
        return 0 <= row && row < n && 0 <= col && col < n;
    }
}