import java.util.Scanner;
public class Main {
    static int n;
    static int[][] map;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int m = sc.nextInt();
        map = new int[n+1][n+1];
        while(m-->0){
            int r = sc.nextInt();
            int c = sc.nextInt();
            map[r][c] = 1;
            if(isCom(r,c)) {
                System.out.println(1);
            }
            else System.out.println(0);
        }
    }
    static boolean isCom(int r, int c){
        int cnt = 0;
        int [] dr = new int[]{-1,0,1,0};
        int [] dc = new int[]{0,1,0,-1};
        for(int i = 0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(inRange(nr,nc) && map[nr][nc] == 1){
                cnt++;
            }
        }
        return cnt>=3;
    }
    static boolean inRange(int r, int c){
        return 0 <= r && r <= n && 0<=c && c <= n;
    }
}