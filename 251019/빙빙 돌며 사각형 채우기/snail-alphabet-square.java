import java.util.Scanner;
public class Main {
    static final int DIR_NUM = 4;
    static int n,m;
    static int[] dr = new int[]{0,1,0,-1};
    static int[] dc = new int[]{1,0,-1,0};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        
        char [][] map = new char[n][m];
        int currR = 0;
        int currC = 0;
        int dir = 0; 
        char apha = 'A';
        map[currR][currC] = apha;
        for(int i = 1; i<n*m; i++){
            int nr = currR + dr[dir];
            int nc = currC + dc[dir];
            if(!inRange(nr,nc) || map[nr][nc] != 0){
                dir = (dir + 1) % DIR_NUM;
                nr = currR + dr[dir];
                nc = currC + dc[dir];
            }
            map[nr][nc] = (char)((apha-'A' + 1) % 26 + 'A');
            apha++;
            currR = nr;
            currC = nc;
        }
        for(char[] arr : map){
            for(char c : arr){
                System.out.print(c+ " ");
            }
            System.out.println();
        }
    }
    static boolean inRange(int r, int c){
        return 0<=r && r<n && 0<=c && c<m;
    }
}