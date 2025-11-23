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
    static Deque<Point> queue = new ArrayDeque<>();

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

        queue.add(new Point(startRow, startCol));



        while(k-->0 && !queue.isEmpty()){

            Point currentPoint = queue.poll();
            
            int nr = -1;
            int nc = -1;
            int mx = 0;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    if(grid[i][j] < grid[currentPoint.row][currentPoint.col]){
                        if(grid[i][j] > mx){
                            mx = grid[i][j];
                            nr = i;
                            nc = j;
                        }
                    }
                }
            }
            if(nr == -1 && nc == -1){
                System.out.println(currentPoint.row + " " + currentPoint.col);
            }
            queue.add(new Point(nr, nc));
        }
        if(!queue.isEmpty()){
            Point p = queue.poll();
            System.out.println(p.row + " " + p.col);
        }

    }
}