import java.util.Scanner;

public class Main {
    static int n;
    static int[] sorted;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] arr = new int[n];
        sorted = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        mergeSort(arr, 0, arr.length - 1);
        for(int a : arr){
            System.out.print(a + " ");
        }

    }
    static void mergeSort(int[] arr, int low, int high){
        if(low < high){
            int mid = (low + high) / 2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid + 1, high);
            merge(arr, low, mid, high);
        }
    }

    
    static void merge(int[] arr, int low, int mid, int high){
        
        int i = low, j = mid + 1;
        int k = low;
        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                sorted[k] = arr[i];
                i++; k++;
            }
            else{
                sorted[k] = arr[j];
                j++; k++;
            }
        }

        while(i<=mid){
            sorted[k] = arr[i];
            i++; k++;
        }
        while(j<=high){
            sorted[k] = arr[j];
            j++; k++;
        }
        for(int l = low; l <= high; l++){
            arr[l] = sorted[l];
        }
    }
}