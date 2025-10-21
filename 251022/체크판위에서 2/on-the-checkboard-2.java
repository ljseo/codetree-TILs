import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int R = sc.nextInt();
        int C = sc.nextInt();
        char[][] grid = new char[R][C];
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        // Please write your code here.
        int cnt = 0;
        for(int i = 1; i<R; i++){
            for(int j = 1; j<C; j++){
                for(int k = i+1; k<R-1; k++){
                    for(int l = j+1; l<C-1; l++){
                        if(grid[0][0] != grid[i][j] &&
                           grid[i][j] != grid[k][l] &&
                           grid[k][l] != grid[R-1][C-1]) 
                           cnt++;
                    }
                }
            }
        }
        System.out.print(cnt);
        // char color = grid[r][c];
        // for(int i = 1; i<R; i++){
        //     for(int j = 1; j<C; j++){
        //         if(grid[i][j] != color){
        //             for(int k = i+1; k<R; k++){
        //                 for(int l = j+1; l<C; l++){
        //                     if(grid[k][l] == color){
        //                         for(int x = k+1; x<R; x++){
        //                             for(int y = l+1; y<C; y++){
        //                                 if(grid[x][y] != color && x == R-1 && y == C-1){
        //                                     cnt++;
        //                                 }
        //                             }
        //                         }
        //                     }
        //                 }
        //             }
        //         }
        //     }
        // }
    }
}