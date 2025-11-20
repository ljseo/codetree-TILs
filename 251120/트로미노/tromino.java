import java.util.Scanner;

public class Main {

    static int n,m;
    static int[][] grid;

    static int[][][] blucks = new int[][][]{
        {{1,0}, {1,1}}, {{0,1},{1,0}}, {{1,0}, {1,1}},
        {{1,0},{1,-1}}, {{1,0},{2,0}}, {{0,1}, {0,2}}
    };

    static int calMax(int i, int j, int k){
        int bluck1R = i;
        int bluck1C = j;
        int bluck2R = i + blucks[k][0][0];
        int bluck2C = j + blucks[k][0][1];
        int bluck3R = i + blucks[k][1][0];
        int bluck3C = j + blucks[k][1][1];
        
        if(0 <= bluck1R && bluck1R < n && 0 <= bluck1C && bluck1C < m
        && 0 <= bluck2R && bluck2R < n && 0 <= bluck2C && bluck2C < m
        && 0 <= bluck3R && bluck3R < n && 0 <= bluck3C && bluck3C < m ){
            return grid[bluck1R][bluck1C] + grid[bluck2R][bluck2C] + grid[bluck3R][bluck3C];
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int mx = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 0; k < blucks.length; k++){
                    mx = Math.max(mx, calMax(i,j,k));
                }
            }
        }
        System.out.print(mx);
    }
}