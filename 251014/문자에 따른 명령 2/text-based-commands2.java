import java.util.Scanner;

public class Main {
    static int[] dx = {-1,0,1,0};
    static int[] dy = {0, 1,0,-1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        // Please write your code here.
        int nx = 0;
        int ny = 0;
        int d = 0;
        for(char c: s.toCharArray()){
            if(c == 'L'){
                d = (d + 3) % 4;
            }
            else if(c == 'R') {
                d = (d + 1) % 4;
            }
            else{
                nx += dx[d];
                ny += dy[d];
            }
        }
        System.out.print(ny +" " + nx);
    }
}