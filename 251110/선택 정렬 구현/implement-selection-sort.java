import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for(int i = 0; i<n-1; i++){
            int mnIdx = i;
            for(int j = i+1; j<n; j++){
                if(arr[j] < arr[mnIdx]){
                    mnIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[mnIdx];
            arr[mnIdx] = arr[i];
        }
        for(int a : arr) System.out.print(a + " ");


    }
}