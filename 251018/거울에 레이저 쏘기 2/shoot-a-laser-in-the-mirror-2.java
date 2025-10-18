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
            else if(grid[x][y] == '\\'){
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
            // System.out.println(x + " " + y);
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
//     static int[] getStartPos(int startNum){
//     if(startNum == 1) return new int[]{0, 0};
    
//     int x = 0, y = 0;
//     int dir = 0;  // 0:오른쪽, 1:아래, 2:왼쪽, 3:위
//     int[] dx = new int[]{0, 1, 0, -1};
//     int[] dy = new int[]{1, 0, -1, 0};
    
//     for(int i = 2; i <= startNum; i++){
//         // 다음 위치로 이동
//         int nx = x + dx[dir];
//         int ny = y + dy[dir];
        
//         // 범위를 벗어나거나 경계가 아니면 방향 전환
//         if(!inRange(nx, ny) ){
//             dir = (dir + 1) % 4;
//             nx = x;
//             ny = y;
//         }
//         x = nx;
//         y = ny;
//     }
    
//     return new int[]{x, y};
// }

    // static int[] getStartPos(int startNum){
    // int idx = startNum - 1;
    
    // if(idx < n) {
    //     // 위쪽 가장자리: (0, idx)
    //     return new int[]{0, idx};
    // }
    // else if(idx < 2*n) {
    //     // 오른쪽 가장자리: (idx-n, n-1)
    //     return new int[]{idx - n, n - 1};
    // }
    // else if(idx < 3*n) {
    //     // 아래쪽 가장자리: (n-1, n-1-(idx-2*n))
    //     return new int[]{n - 1, n - 1 - (idx - 2*n)};
    // }
    // else {
    //     // 왼쪽 가장자리: (n-1-(idx-3*n), 0)
    //     return new int[]{n - 1 - (idx - 3*n), 0};
    // }
// }
    static int[] getStartPos(int startNum){
        if(startNum == 1) return new int[]{0,0};
        int [] dx = new int[]{0,1,0,-1};
        int [] dy = new int[]{1,0,-1,0};
        int x = 0;
        int y = 0;
        int dir = 0;
        for(int i = 2; i<=startNum;i++){
            if(i % n == 0) {
                dir = (dir+1) % 4;
            }
            else if((i-1) % n == 0);
            else{
                x += dx[dir];
                y += dy[dir];
            }
        }
        return new int[]{x,y};
    }
}