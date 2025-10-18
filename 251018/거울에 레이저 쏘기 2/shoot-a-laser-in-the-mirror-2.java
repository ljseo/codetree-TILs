import java.util.Scanner;

public class Main {
    static int n;
    static int[] dx = new int[]{1,0,-1,0};
    static int[] dy = new int[]{0,-1,0,1};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            for (int j = 0; j < n; j++) {
                grid[i][j] = s.charAt(j);
            }
        }
        int startNum = sc.nextInt();
        int dir  = getStartDir(startNum);
        int[] startPos = getStartPos(startNum);
        int x = startPos[0];
        int y = startPos[1];
        // System.out.println(dir);
        // System.out.println(x +" "+ y);
        int cnt = 0;
        while(inRange(x,y)){
            if(grid[x][y] == '/'){
                if(dir % 2 == 0) dir += 1;
                else dir -= 1;
            }
            else{
                if(dir % 2 == 0){
                    dir = (dir+3)%4;
                }
                else{
                    dir = (dir-3+4) %4;
                }
            }
            cnt++;
            x += dx[dir];
            y += dy[dir];
        }
        System.out.print(cnt);
    }
    static boolean inRange(int x, int y){
        return 0<=x && x<n && 0<=y && y<n;
    }
    static int getStartDir(int startNum){
        // if(((startNum-1) / n) == 0) return 0;
        // else if(((startNum-1) / n) == 1) return 1;
        // else if(((startNum-1) / n) == 2) return 2;
        // else return 3;
        return (startNum-1) / n;
    }
    static int[] getStartPos(int startNum){
        if(startNum == 1) return new int[]{0,0};
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        int x = 0;
        int y = 0;
        int dir = 0;
        for(int i = 2; i<=4*n;i++){
            if(i % n == 0) {
                dir = (dir+1) % 4;
            }
            else{
                x += dx[dir];
                y += dy[dir];
            }
            if(i == startNum) return new int[]{x,y};
        }
        return new int[]{0,0};
    }
}