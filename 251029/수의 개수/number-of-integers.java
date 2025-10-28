import java.util.Scanner;
public class Main {
    static final int MAX_N = 1_000_000;
    static int[] arr = new int[MAX_N];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int upperBoundIdx = upperBound(x);
            int lowerBoundIdx = lowerBoundIdx(x);
            System.out.println(upperBoundIdx - lowerBoundIdx);
        }
    }
    static int lowerBoundIdx(int x){

        int left = 0;
        int right = n-1;
        int mn = n;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] >= x){
                right = mid - 1;
                mn = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return mn;
    }
    static int upperBound (int x){
        int left = 0;
        int right = n-1;
        int mn = n;

        while(left <= right){
            int mid = (left + right) /2 ;
            if(arr[mid] > x){
                right = mid - 1;
                mn = mid;
            }
            else{
                left = mid + 1;
            }
        }
        return mn;
    }
}