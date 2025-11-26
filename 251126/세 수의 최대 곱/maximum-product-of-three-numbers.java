import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(arr);

        long max1 = arr[N - 1];
        long max2 = arr[N - 2];
        long max3 = arr[N - 3];

        long min1 = arr[0];
        long min2 = arr[1];

        long candidate1 = max1 * max2 * max3;
        long candidate2 = min1 * min2 * max1;

        System.out.println(Math.max(candidate1, candidate2));
    }
}
