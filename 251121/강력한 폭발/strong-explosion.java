import java.util.*;

class Pos{
    int row;
    int col;
    public Pos(int row, int col){
        this.row = row;
        this.col = col;
    }
}

public class Main {

    static final int BOMBS_KIND = 3;
    static final int BOMBS_DIR = 5;

    static int n;
    static int[] bombsNum;
    static int bombPosCnt;
    static int[][] grid;
    static int mx = 0;
    static ArrayList<Pos> bombsPos = new ArrayList<>();
    static int[][] bombsDr = {{0,-1,-2,1,2}, {0,-1,0,1,0},{0,-1,-1,1,1}};
    static int[][] bombsDc = {{0,0,0,0,0},{0,0,1,0,-1},{0,-1,1,1,-1}};
    static int[][] temp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        bombPosCnt = 0;
        grid = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                grid[i][j] = sc.nextInt();
                if(grid[i][j] == 1) {
                    bombPosCnt++;
                    bombsPos.add(new Pos(i,j));
                }
            }
        }
        bombsNum = new int[bombPosCnt];
        createBombsSeq(0);
        System.out.println(mx);
    }


    static void createBombsSeq(int cnt){
        if(cnt == bombPosCnt){
            mx = Math.max(mx, getDestroyArea());
            return;
        }
        for(int i = 0; i < BOMBS_KIND; i++){
            bombsNum[cnt] = i;
            createBombsSeq(cnt+1);
        }
    }

    static int getDestroyArea(){
        temp = new int[n][n];
        for(int i = 0; i < bombPosCnt; i++){
            Pos bombPos = bombsPos.get(i);
            int bombNum = bombsNum[i];
            destroyArea(bombPos.row, bombPos.col, bombNum);
        }
        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(temp[i][j] == -1) cnt++;
            }
        }
        return cnt;
    }

    static void destroyArea(int row, int col, int bombNum){
        for(int i = 0; i < BOMBS_DIR; i++){
            int nr = row + bombsDr[bombNum][i];
            int nc = col + bombsDc[bombNum][i];
            if(inRange(nr, nc)){
                temp[nr][nc] = -1;
            }
        }
    }
    static boolean inRange(int row, int col){
        return 0 <= row && row < n && 0 <= col && col < n;
    }

}