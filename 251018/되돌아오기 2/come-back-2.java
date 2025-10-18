import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String commands = sc.next();
        // Please write your code here.
        int [] dx = new int[]{-1,0,1,0};
        int [] dy = new int[]{0,1,0,-1};
        int cnt = 0;
        int dir = 0;
        int x = 0;
        int y = 0;
        for(char c : commands.toCharArray()){
            cnt++;
            if(c == 'L'){
                dir = dir - 1;
                if(dir == -1) dir = 3;
            }
            else if(c == 'R'){
                dir = (dir + 1) % 4; 
            }
            else{
                x += dx[dir];
                y += dy[dir];
                if(x == 0 && y==0){
                    System.out.print(cnt);
                    return;
                }
            }
        }
        System.out.print(-1);
    }
}