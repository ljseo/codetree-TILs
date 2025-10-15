import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int T = sc.nextInt();
        int R = sc.nextInt()-1;
        int C = sc.nextInt()-1;
        String D = sc.next();
        // Please write your code here.

        int[] dx = new int[]{-1,0,0,1};
        int[] dy = new int[]{0,1,-1,0};;
        int nd = getDir(D);
        while(T-->0){
            int nx = R + dx[nd];
            int ny = C + dy[nd];
            if(inRange(nx, ny, N)){
                R = nx;
                C = ny;
            }
            else {
                nd = 3 - nd;
            }
        }
        R++; C++;
        System.out.print(R +" " + C);
    }
    static int getDir(String D){
        if(D.equals("U")) return 0;
        else if(D.equals("R")) return 1;
        else if(D.equals("L")) return 2;
        else return 3;
    }
    static boolean inRange(int x, int y, int n){
        return 0 <= x && x < n && 0 <= y && y < n; 
    }
}