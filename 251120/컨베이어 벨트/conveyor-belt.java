import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] arr = new int[2*n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = n; i < 2*n; i++) {
            arr[i] = sc.nextInt();
        }

        while(t-->0){
            int temp = arr[arr.length-1];
            for(int i = 2*n-1; i > 0; i--){
                arr[i] = arr[i-1];
            }
            arr[0] = temp;
        }
        for(int i = 0; i < 2*n; i++){
            if(i == n) System.out.println();
            System.out.print(arr[i] + " ");
        }
    }
}