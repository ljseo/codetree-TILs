import java.util.Scanner;

public class Main {
    static int n;
    static int[] dr = new int[]{0,-1,0,1};
    static int[] dc = new int[]{-1,0,1,0};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int currR = n-1;
        int currC = n-1;
        int dir = 0;
        int[][] map = new int[n][n];
        map[currR][currC] = n*n;
        
        for(int i = n*n-1; i>0; i--){
            int nr = currR + dr[dir];
            int nc = currC + dc[dir];
            if(!inRange(nr,nc) || map[nr][nc] != 0){
                dir = (dir+1) % 4;
                nr = currR + dr[dir];
                nc = currC + dc[dir];
            }
            map[nr][nc] = i;
            currR = nr;
            currC = nc;
        }
        for(int[] arr : map){
            for(int a : arr){
                System.out.print(a +" ");
            }
            System.out.println();
        }

    }
    static boolean inRange(int r, int c){
        return 0<=r && r<n && 0<=c && c<n;
    } 
}