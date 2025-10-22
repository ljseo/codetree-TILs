import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int ans = Integer.MAX_VALUE;
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = 0; j<n; j++){
                int diff = j - i;
                if(diff < 0) diff += n;
                sum = sum + (diff * arr[j]);
            }
            ans = Math.min(ans, sum);
        }
        System.out.print(ans);
    }
}