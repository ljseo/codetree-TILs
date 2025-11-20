import java.util.Scanner;
public class Main {

    static int n,m,q;
    static int[][] building;

    static void shift(int r1, int c1, int r2, int c2){
        int temp = building[r1][c1];
        for(int i = r1; i < r2; i++){
            building[i][c1] = building[i+1][c1];
        }
        for(int i = c1; i < c2; i++){
            building[r2][i] = building[r2][i+1];
        }
        for(int i = r2; i > r1; i--){
            building[i][c2] = building[i-1][c2];
        }
        for(int i = c2; i > c1; i--){
            building[r1][i] = building[r1][i-1];
        }
        building[r1][c1+1] = temp;
    }

    static int getAroundAge(int r, int c){
        int sum = building[r][c];
        int cnt = 1;
        if(r+1 < n) {
            sum += building[r+1][c];
            cnt++;
        }
        if(c+1 < m){
            sum += building[r][c+1];
            cnt++;
        }
        if(r-1 >= 0){
            sum += building[r-1][c];
            cnt++;
        }
        if(c-1 >= 0){
            sum += building[r][c-1];
            cnt++;
        }
        return sum / cnt;
    }

    static void chageAvg(int r1, int c1, int r2, int c2){
        
        int rLen = r2-r1+1;
        int cLen = c2-c1+1;
        int[][] temp = new int[r2-r1+1][c2-c1+1];
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                temp[i-r1][j-c1] = getAroundAge(i,j);
            }
        }
        for(int i = r1; i <= r2; i++){
            for(int j = c1; j <= c2; j++){
                building[i][j] = temp[i-r1][j-c1];
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        q = sc.nextInt();
        building = new int[n][m];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                building[i][j] = sc.nextInt();
        int[][] queries = new int[q][4];
        for (int i = 0; i < q; i++)
            for (int j = 0; j < 4; j++)
                queries[i][j] = sc.nextInt();

        for (int i = 0; i < q; i++){
            int r1 = queries[i][0] - 1;
            int c1 = queries[i][1] - 1;
            int r2 = queries[i][2] - 1;
            int c2 = queries[i][3] - 1;
            shift(r1,c1,r2,c2);
            chageAvg(r1,c1,r2,c2);
        }

        for(int [] arr : building){
            for(int a : arr){
                System.out.print(a + " ");
            }
            System.out.println();
        }


    }
}