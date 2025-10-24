import java.util.Scanner;
public class Main {
    static final int MAX_N = 100;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[MAX_N + 1];
        for (int i = 0; i < n; i++) {
            int cnt = sc.nextInt();
            int pos = sc.nextInt();
            candies[pos] += cnt;
        }

        int mx = 0;
        for(int i = 0; i<=MAX_N; i++){
            int sum = 0;
            for(int j = i - k; j<= i+k; j++){
                if(j >= 0 && j <= MAX_N){
                    sum += candies[j];
                }
            }
            mx = Math.max(mx, sum);
        }
        System.out.print(mx);
    }
}