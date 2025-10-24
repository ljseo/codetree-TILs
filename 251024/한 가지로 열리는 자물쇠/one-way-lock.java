import java.util.Scanner;
public class Main {
    static final int MAX_N = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int cnt = 0;
        for(int i = 1; i<= n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    int first = Math.abs(i-a);
                    int second = Math.abs(j-b);
                    int third = Math.abs(k-c);
                    if(first < 3 || second < 3 || third <3) cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}