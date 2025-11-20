import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int mx = -1;
        for(int i = 0; i <= grid.length-3; i++){
            for(int j = 0; j <= grid[i].length-3; j++){
                int sum = 0;
                sum += grid[i][j] + grid[i+1][j] + grid[i+2][j];
                sum += grid[i][j+1] + grid[i+1][j+1] + grid[i+2][j+1];
                sum += grid[i][j+2] + grid[i+1][j+2] + grid[i+2][j+2];
                mx = Math.max(mx, sum);
            }
        }
        System.out.print(mx);
    }
}