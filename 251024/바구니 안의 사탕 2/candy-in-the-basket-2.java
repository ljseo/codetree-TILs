import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] candies = new int[n];
        int[] positions = new int[n];
        for (int i = 0; i < n; i++) {
            candies[i] = sc.nextInt();
            positions[i] = sc.nextInt();
        }

        int [] cnt = new int[101];
        for(int i = 0; i<n; i++){
            int pos = positions[i];
            cnt[pos] = candies[i];
        }

        int mx = 0;
        for(int i = 0; i <= 100 -2*k; i++){
            int sum = 0;
            for(int j = 0; j<= 2*k; j++){
                sum += cnt[i + j];
            }
            //System.out.println(sum);
            mx = Math.max(mx, sum);
        }
        System.out.print(mx);
    }
}