import java.util.Scanner;

public class Main {
    static final int MAX_N = 10_000;
    static final int MAX_INT_SIZE = 100_000;
    static int n,m;
    static int[] arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int left = 1;
        int right = MAX_INT_SIZE;
        int k = 0;

        while(left <= right){
            int mid = (left + right) / 2;
            if(isPossible(mid)) {
                left = mid + 1;
                k = Math.max(k, mid);
            }
            else{
                right = mid - 1;
            }
        }
        System.out.print(k);
    }
    static boolean isPossible(int k){
        
        int cnt = 0;
        for(int i = 0; i<n; i++){
            cnt += (arr[i] / k);
        }
        return cnt >= m;
    }
}