import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        int ans = -1001;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            a[i] = sc.nextInt();
            sum += a[i];
            ans = Math.max(ans, sum);
            if(sum < 0) sum = 0;
        }
        System.out.println(ans);

    }
}