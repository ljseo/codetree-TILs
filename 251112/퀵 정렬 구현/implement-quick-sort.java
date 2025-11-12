import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        quickSort(arr, 0, arr.length - 1);

        for(int a: arr){
            System.out.print(a + " ");
        }
    }
    static void quickSort(int [] arr, int low, int high){
        if(low < high){
            int pos = partition(arr, low, high);
            quickSort(arr, low, pos-1);
            quickSort(arr, pos+1, high);
        }
    }
    static int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int l = low - 1;
        for(int i = low; i<high; i++){
            
            if(arr[i] < pivot){
                l++;
                int temp = arr[l];
                arr[l] = arr[i];
                arr[i] = temp;
            }
        }
        l++;
        int temp = arr[l];
        arr[l] = arr[high];
        arr[high] = temp;
        return l;
    }
}