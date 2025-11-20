import java.util.Scanner;

public class Main {

    static final int SHIFT_LEFT = 1;
    static final int SHIFT_RIGHT = 0;
    
    static int n,m,q;
    static int[][] a;

    static void shift(int row, int dir){
        if(dir == SHIFT_RIGHT){
            int temp = a[row][m-1];
            for(int i = m-1; i > 0; i--){
                a[row][i] = a[row][i-1];
            }
            a[row][0] = temp;
        }

        else{
            int temp = a[row][0];
            for(int i = 0; i < m-1; i++){
                a[row][i] = a[row][i+1];
            }
            a[row][m-1] = temp;
        }
    }

    public static boolean hasSameNumber(int row1, int row2) {
        for(int col = 0; col < m; col++)
            if(a[row1][col] == a[row2][col])
                return true;
        
        return false;
    }

    static int flip(int dir){
        return dir == SHIFT_LEFT ? SHIFT_RIGHT : SHIFT_LEFT;
    }

    static void simulate(int startRow, int startDir){

        shift(startRow, startDir);
        startDir = flip(startDir);
        
        int dir = startDir;
        for(int row = startRow; row > 0; row--){
            if(hasSameNumber(row, row-1)){
                shift(row-1, dir);
                dir = flip(dir);
            }
            else {
                break;
            }
        }
        dir = startDir;
        for(int row = startRow; row < n-1; row++){
            if(hasSameNumber(row,row+1)){
                shift(row+1, dir);
                dir = flip(dir);
            }
            else {
                break;
            }
        }

    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        a = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                a[i][j] = sc.nextInt();
        while(q-->0){
            int r = sc.nextInt() - 1;
            char d = sc.next().charAt(0);
            
            simulate(r, d == 'L' ? SHIFT_RIGHT : SHIFT_LEFT);

        }

        for(int [] arr : a){
            for(int v : arr){
                System.out.print(v + " ");
            }
            System.out.println();
        }
        
    }
}