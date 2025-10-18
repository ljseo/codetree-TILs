import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dx = new int[]{-1,0,1,0};
        int[] dy = new int[]{0,1,0,-1};
        int x = 0;
        int y = 0;
        int cnt = 0;
        for(int i = 0; i < n; i++){
            char dir = sc.next().charAt(0);
            int dist = sc.nextInt();
            int d = getDir(dir);
            while(dist-->0){
                cnt++;
                x += dx[d];
                y += dy[d];
                if(x == 0 && y == 0) {
                    System.out.print(cnt);
                    return;
                }
            }
        }
        System.out.print(-1);
    }
    static int getDir(char d){
        if(d == 'N') return 0;
        else if(d == 'E') return 1;
        else if(d == 'S') return 2;
        else return 3;
    }
    
}