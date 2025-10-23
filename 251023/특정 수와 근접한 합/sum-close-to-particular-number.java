import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int mn = Integer.MAX_VALUE;
        int sum = 0;
        for(int a : arr){
            sum += a;
        }
        int cnt = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                cnt = sum - arr[i] - arr[j];
                mn = Math.min(mn, Math.abs(s-cnt));
            }
        }
        System.out.print(mn);
    }
}