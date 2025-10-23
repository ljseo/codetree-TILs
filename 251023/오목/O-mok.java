import java.util.Scanner;

public class Main {
    static final int MAX_N = 19;
    static int[][] arr = new int[MAX_N][MAX_N];
    static int ansR = 0, ansC = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 19; i++) {
            for (int j = 0; j < 19; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        
        int res = 0;

        for(int i = 0; i<19; i++){
            for(int j = 0; j<19; j++){
                if(arr[i][j] != 0){
                    if(isWin(i,j)){
                        res = arr[i][j] == 1 ? 1 : 2;
                    }
                }
            }
        }
        System.out.println(res);
        ansR++; ansC++;
        System.out.print(ansR + " " + ansC);

    }
    static boolean isWin(int r, int c){
        int start = arr[r][c];
        int[] dr = new int[]{0,1,1,1};
        int[] dc = new int[]{1,1,0,-1};
        for(int i =0; i<4; i++){
            int nr = r + dr[i];
            int nc = c + dc[i];
            int cnt = 0;
            while(inRange(nr, nc) && arr[nr][nc] == start){
                cnt++;
                if(cnt == 4) {
                    ansR = nr -dr[i] *2;
                    ansC = nc -dc[i] *2;
                    return true;
                }
                nr += dr[i];
                nc += dc[i];
            }
        }
        return false;
    }
    static boolean inRange(int r, int c){
        return 0<=r && r<MAX_N && 0<=c && c<MAX_N;
    }
}