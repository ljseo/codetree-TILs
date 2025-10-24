import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        int cnt = 0;
        for(int i = 0; i<n; i++){
            int sum = 0;
            for(int j = i; j<n; j++){
                sum += arr[j];
                int avg = sum / (j-i+1);;
                for(int k = i; k<j;k++){
                    if(arr[k] == avg) {
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}