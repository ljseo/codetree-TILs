import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int h = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int mn = Integer.MAX_VALUE;
        for(int i = 0; i<=n-t; i++){
            int sum = 0;
            for(int j = 0; j<t; j++){
                sum += Math.abs(h - arr[i+j]);
            }
            mn = Math.min(mn, sum);
        }
        System.out.println(mn);
    }
}