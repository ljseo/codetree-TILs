import java.util.*;

public class Main {

    static final int MAX_N = 200;
    static final int DIR_NUM = 4;
    static int n, r, c;
    static int[][] grid = new int[MAX_N+1][MAX_N+1];
    static int[] dr = {-1,0,1,0};
    static int[] dc = {0,1,0,-1};

    static boolean isRange(int row, int col){
        return row < n && 0 <= row && col < n && 0 <= col;
    }
    static void bomb(){

        int power = grid[r][c];
        grid[r][c] = 0;

        int cr = r;
        int cc = c;
        for(int i = 0; i < DIR_NUM; i++){
            cr = r;
            cc = c;
            for(int j = 1; j < power; j++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(isRange(nr, nc)) {
                    grid[nr][nc] = 0;
                    cr = nr;
                    cc = nc;
                }
            }
        }
    }

    static void down(){
        int[][] temp = new int[MAX_N][MAX_N];
        for(int i = 0; i < n; i++){
            int tempIdx = n-1;
            for(int j = n - 1; j >= 0; j--){
                if(grid[j][i] != 0){
                    temp[tempIdx--][i] = grid[j][i];
                }
            }
        }
        grid = temp;
    }

    static void simulation(){
        bomb();
        down();
    }


    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        r = sc.nextInt()-1;
        c = sc.nextInt()-1;
        simulation();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}