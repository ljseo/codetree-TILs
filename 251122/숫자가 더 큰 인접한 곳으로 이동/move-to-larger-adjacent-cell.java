import java.util.*;


class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static final int MAX_N = 100;
    static final int DIR_NUM = 4;
    static int n, r, c;
    static int[][] grid = new int[MAX_N][MAX_N];
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = { 0, 0,-1, 1};
    

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt() - 1;
        c = sc.nextInt() - 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
            }
        }
        simulation();
    }
    static void simulation(){

        Pair currentPos = new Pair(r,c);
        while(true){
            System.out.print(grid[currentPos.row][currentPos.col] + " ");
            Pair nextPos = getMovePos(currentPos);
            if(nextPos.row == currentPos.row && nextPos.col == currentPos.col) break;
            currentPos = nextPos;
        }
    }
    static Pair getMovePos(Pair currentPos){

        for(int i = 0; i < DIR_NUM; i++){
            int nr = currentPos.row + dr[i];
            int nc = currentPos.col + dc[i];
            if(0 <= nr && nr < n && 0 <= nc && nc < n){
                if(grid[nr][nc] > grid[currentPos.row][currentPos.col]){
                    return new Pair(nr, nc);
                }
            } 
        }
        return currentPos;
    }
}