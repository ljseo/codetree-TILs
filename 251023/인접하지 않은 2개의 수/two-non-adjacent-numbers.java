import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = sc.nextInt();
        }

        int sum = 0;
        int mx = -1;
        for(int i = 0; i<n; i++){
            sum = 0;
            for(int j = i+2; j<n; j++){
                sum = arr[i] + arr[j];
                mx = Math.max(mx, sum);
            }
        }
        System.out.print(mx);
    }
}