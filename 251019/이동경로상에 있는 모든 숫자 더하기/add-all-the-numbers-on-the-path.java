import java.util.Scanner;

public class Main {

    static int n;
    static int[] dr = new int[]{-1,0,1,0};
    static int[] dc = new int[]{0,1,0,-1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int t = sc.nextInt();
        String commands = sc.next();
        int[][] board = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int currR = n/2;
        int currC = n/2;
        int dir = 0;
        int sum = board[currR][currC];

        for(char command : commands.toCharArray()){
            if(command == 'L'){
                dir = (dir-1+4) % 4;
            }
            else if(command == 'R'){
                dir = (dir + 1) % 4;
            }
            else{
                int nr = currR + dr[dir];
                int nc = currC + dc[dir];
                if(inRange(nr,nc)){
                    sum += board[nr][nc];
                    currR = nr;
                    currC = nc;
                }
            }
        }
        System.out.println(sum);
    }
    static boolean inRange(int r, int c){
        return 0<=r && r<n && 0<=c && c<n;
    }
}