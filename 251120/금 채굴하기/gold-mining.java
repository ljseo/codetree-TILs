import java.util.Scanner;

public class Main {

    static int n,m;
    static int[][] grid;
    
    static int getNumOfGold(int row, int col, int k){
        int numOfGold = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(Math.abs(row-i) + Math.abs(col-j) <= k){
                    if(grid[i][j] == 1) numOfGold++;
                }
            }
        }
        return numOfGold;
    }

    static int getArea(int k){
        return k*k + (k+1) * (k+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();

        int maxGold = 0;
        for(int row = 0; row < n; row++){
            for(int col = 0; col < n; col++){
                for(int k = 0; k <= 2*(n-1); k++){
                    int numOfGold = getNumOfGold(row, col, k);
                    if(getArea(k) <= numOfGold * m){
                        maxGold = Math.max(maxGold, numOfGold);
                    }
                }
            }
        }
        System.out.print(maxGold);
    }
}