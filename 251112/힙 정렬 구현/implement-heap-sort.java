import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n+1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = n/2; i>0; i--){
            heapify(arr, i, n);
        }
        
        for(int i = n; i>1; i--){
            int temp = arr[i];
            arr[i] = arr[1];
            arr[1] = temp;
            heapify(arr, 1, i-1);
        }

        for(int i = 1; i<=n; i++)System.out.print(arr[i] + " ");


    }
    static void heapify(int[] arr, int i, int n){
        
        int mx = i;
        int l = i * 2;
        int r = i * 2 + 1;

        if(l <= n && arr[mx] < arr[l]){
            mx = l;
        }
        if(r <= n && arr[mx] < arr[r]){
            mx = r;
        }

        if(arr[mx] != arr[i]){
            int temp = arr[i];
            arr[i] = arr[mx];
            arr[mx] = temp;
            heapify(arr, mx, n);
        }

    }
}