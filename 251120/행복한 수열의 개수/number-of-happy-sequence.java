import java.util.Scanner;
  
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int ans = 0;
        for(int i = 0; i < n; i++){
            int num = grid[i][0];
            int seq = 1;
            int mxSeq = 1;
            for(int j = 1; j < n; j++){
                int num2 = grid[i][j];
                if(num == num2){
                    seq++;
                }
                else{
                    seq = 1;
                }
                mxSeq = Math.max(mxSeq, seq);
                num = num2;
            }
            if(mxSeq >= m){
                ans++;
            }
        }
        for(int i = 0; i < n; i++){
            int num = grid[0][i];
            int seq = 1;
            int mxSeq = 1;
            for(int j = 1; j < n; j++){
                int num2 = grid[j][i];
                if(num == num2){
                    seq++;
                }
                else{
                    seq = 1;
                }
                mxSeq = Math.max(mxSeq, seq);
                num = num2;
            }
            if(mxSeq >= m) ans++;
        }
        System.out.print(ans);

    }
}