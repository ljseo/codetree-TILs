import java.util.Scanner;

public class Main {
    static int n,m,q;
    static int[][] a;

    static boolean isPos(int r1, int r2){
        for(int i = 0; i < m; i++){
            if(a[r1][i] == a[r2][i]) return true;
        }
        return false;
    }

    static void leftShift(int r){
        int temp = a[r][m-1];
        for(int i = m-1; i > 0; i--){
            a[r][i] = a[r][i-1];
        }
        a[r][0] = temp;
    }

    static void rightShift(int r){
        int temp = a[r][0];
        for(int i = 0; i < m-1; i++){
            a[r][i] = a[r][i+1];
        }
        a[r][m-1] = temp;
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
        for (int t = 0; t < q; t++) {
            int r = sc.nextInt() - 1;
            char d = sc.next().charAt(0);
            char di = d;
            if(d == 'L') {
                leftShift(r);
                d = 'R';
                di = d;
            }
            else {
                rightShift(r);
                d = 'L';
                di = d;
            }
            for(int i = r-1; i>=0; i--){
                if(!isPos(i,i+1)) break;
                if(d == 'L') {
                    leftShift(i);
                    d = 'R';
                }
                else {
                    rightShift(i);
                    d = 'L';
                }
            }
            d = di;
            for(int i = r+1; i<n; i++){
                if(!isPos(i,i-1)) break;
                if(d == 'L') {
                    leftShift(i);
                    d = 'R';
                }
                else {
                    rightShift(i);
                    d = 'L';
                }
            }
        }
        for(int [] arr : a){
            for(int v : arr){
                System.out.print(v + " ");
            }
            System.out.println();
        }
        
    }
}