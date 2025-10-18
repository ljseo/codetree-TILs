import java.util.Scanner;
public class Main {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int[][] map = new int[n][m];

        int r = 0;
        int c = 0;

        int[] dr = new int[] {1,0,-1,0};
        int[] dc = new int[] {0,1,0,-1};
        int dir = 0;
        map[r][c] = 1;
        for(int i = 2; i<=n*m; i++){
            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if(!inRange(nr, nc) || map[nr][nc] != 0){
                dir = (dir+1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }
            map[nr][nc] = i;
            r = nr;
            c = nc;
        }
        for(int[] arr : map){
            for(int a: arr){
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
    static boolean inRange(int r, int c){
        return 0<=r && r < n && 0<=c && c<m;
    }
}