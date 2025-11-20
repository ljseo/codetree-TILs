import java.util.Scanner;

public class Main {

    static int n,m;
    static int[][] grid;

    static int[][] bluck1 = new int[][]{
        {0,1,0},
        {1,1,1},
        {0,1,0}
    };
    static int[][] bluck2 = new int[][]{
        {0,0,1,0,0},
        {0,1,1,1,0},
        {1,1,1,1,1},
        {0,1,1,1,0},
        {0,0,1,0,0}
    };
    
    static int getMaxGold(int i, int j){
        int maxGold = 0;
        if(grid[i][j] == 1){
            if(m >= 1) maxGold = 1;
        }
        
        int goldCnt = 0;
        for(int k = 0; k < bluck1.length; k++){
            for(int l = 0; l < bluck1[k].length; l++){
                if(bluck1[k][l] != 1) continue;
                if(n <= i + k || n <= j + l) continue;
                if(grid[i+k][j+l] == 1) goldCnt++;
            }
        }
        if(goldCnt * m > 4) {
            maxGold = goldCnt;
        }

        goldCnt = 0;
        for(int k = 0; k < bluck2.length; k++){
            for(int l = 0; l < bluck2[k].length; l++){
                if(bluck2[k][l] != 1) continue;
                if(n <= i + k || n <= j + l) continue;
                if(grid[i+k][j+l] == 1) goldCnt++;
            }
        }
        if(goldCnt * m > 13) {
            maxGold = goldCnt;
        }
        return maxGold;
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
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                maxGold = Math.max(maxGold, getMaxGold(i,j));
            }
        }
        System.out.print(maxGold);
    }
}