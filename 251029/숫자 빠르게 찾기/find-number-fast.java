import java.util.Scanner;
public class Main {
    static int[] arr;
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            System.out.println(binarySearch(x));
        }
    }
    static int binarySearch(int x){

        int left = 0;
        int right = n-1;

        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] == x) {
                return mid + 1;
            }
            if(arr[mid] > x){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return -1;
    }
}