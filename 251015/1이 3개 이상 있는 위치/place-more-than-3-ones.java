import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        // Please write your code here.
        int [] dx = {-1, 0, 1, 0};
        int [] dy = {0,1,0,-1};

        int res = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n;j++){
                int cnt = 0;
                for(int k = 0; k<4; k++){
                    int nx = i + dx[k];
                    int ny = j+ dy[k];
                    if(inRange(nx,ny,n) && arr[nx][ny] == 1){
                        cnt++;
                    }
                }
                if(cnt >= 3) res++;
            }
        }
        System.out.println(res);

    }

    static boolean inRange(int x, int y, int n){
        return x<n && x>=0 && y<n && y>=0;
    }


}