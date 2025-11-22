import java.util.*;

public class Main {

    static final int MAX_N = 20;
    static final int DIR_CNT = 4;
    static int n;
    static int[][] grid = new int[MAX_N+1][MAX_N+1];
    static int[] dr = {-1,-1, 1, 1};
    static int[] dc = { 1,-1,-1, 1};
    static int ans = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                drawRectangle(i, j);
            }
        }
        System.out.print(ans);
    }
    static void drawRectangle(int row, int col){

        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                int res = getDrawRec(row, col, i,j);
                ans = Math.max(ans, res);
            }
        }
    }
    static int getDrawRec(int row, int col, int rightDiagonalCnt, int leftDiagonalCnt){
        
        int cr = row;
        int cc = col;
        int sum = 0;
        for(int i = 0; i < DIR_CNT; i++){
            int cnt = 0;
            if(i % 2 == 0){
                cnt = rightDiagonalCnt;
            }
            else{
                cnt = leftDiagonalCnt;
            }
            for(int j = 0; j < cnt; j++){
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                if(0 <= nr && nr < n && 0 <= nc && nc < n){
                    sum += grid[nr][nc];
                }
                else{
                    return -1;
                }
                cr = nr;
                cc = nc;
            }
        }
        return sum;
    }
}