import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int cnt = 0;
        int idx = n-1;
        while(k > 0){
            int coin = coins[idx--];
            cnt += k/coin;
            k %= coin;
        }
        System.out.println(cnt);
    }
}