import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        
        char[] arr = new char[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.next().charAt(0);
        }
        sc.close();

        int count = 0;

        // 단순 O(N^2) inversion 카운트 (N ≤ 26이므로 충분히 빠름)
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                if (arr[i] > arr[j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
