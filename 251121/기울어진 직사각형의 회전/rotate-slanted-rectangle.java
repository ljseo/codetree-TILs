import java.util.Scanner;
public class Main {

    static final int ROTATE = 1;
    static final int REVERSE_ROTATE = 0;

    static int[] reverseDr = {-1, -1, 1, 1};
    static int[] reverseDc = {-1,  1, 1, -1};
    static int[] dr = {-1, -1,  1, 1};
    static int[] dc = { 1, -1, -1, 1};
    

    static int[][] grid;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        int r = sc.nextInt() - 1;
        int c = sc.nextInt() - 1;
        int m1 = sc.nextInt();
        int m2 = sc.nextInt();
        int m3 = sc.nextInt();
        int m4 = sc.nextInt();
        int dir = sc.nextInt();

        int temp = grid[r][c];
        if(dir == ROTATE){
            int cr = r;
            int cc = c;
            for(int i = 0; i < m1; i++){
                int nr = cr + dr[0];
                int nc = cc + dc[0];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }
            
            for(int i = 0; i < m2; i++){
                int nr = cr + dr[1];
                int nc = cc + dc[1];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }            
            for(int i = 0; i < m3; i++){
                int nr = cr + dr[2];
                int nc = cc + dc[2];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }            
            for(int i = 0; i < m4; i++){
                int nr = cr + dr[3];
                int nc = cc + dc[3];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }
            grid[r-1][c-1] = temp;
        }
        else{
            int cr = r;
            int cc = c;
            for(int i = 0; i < m4; i++){
                int nr = cr + reverseDr[0];
                int nc = cc + reverseDc[0];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }
            for(int i = 0; i < m3; i++){
                int nr = cr + reverseDr[1];
                int nc = cc + reverseDc[1];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }            
            for(int i = 0; i < m2; i++){
                int nr = cr + reverseDr[2];
                int nc = cc + reverseDc[2];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }            
            for(int i = 0; i < m1; i++){
                int nr = cr + reverseDr[3];
                int nc = cc + reverseDc[3];
                grid[cr][cc] = grid[nr][nc];
                cr = nr;
                cc = nc;
            }
            grid[r-1][c+1] = temp;
        }
        for(int[] arr : grid){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
        }
    }
}