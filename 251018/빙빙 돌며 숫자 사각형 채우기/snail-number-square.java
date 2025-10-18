import java.util.Scanner;
public class Main {
    static int n;
    static int m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        // Please write your code here.

        int [][] answer = new int[n][m];
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};

        int x = 0;
        int y = 0;
        answer[x][y] = 1;
        int dir = 0;
        for(int i = 2; i<=n*m;i++){
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            if(inRange(nx,ny) && answer[nx][ny] == 0){
                x = nx;
                y = ny;
                answer[x][y] = i;
            }
            else{
                dir = (dir+1) % 4;
                i--;
            }
        }

        for(int [] arr :answer){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
        }

    }
    static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y&& y<m;
    }
}