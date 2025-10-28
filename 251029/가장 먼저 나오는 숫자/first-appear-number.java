import java.util.Scanner;
public class Main {
    static final int MAX_N = 1_000_000;
    static int n,m;
    static int[] arr = new int[MAX_N];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] queries = new int[m];
        for (int i = 0; i < m; i++) {
            queries[i] = sc.nextInt();
            System.out.println(lowerBound(queries[i]));
        }
    }
    static int lowerBound(int x){
        int left = 0;
        int rigth = n-1;
        int mnIdx = n;
        while(left <= rigth){
            int mid = (left + rigth) / 2;
            if(arr[mid] >= x){
                rigth = mid - 1;
                mnIdx = mid;
            }
            else{
                left = mid + 1;
            }
        }
        
        if(mnIdx == n || arr[mnIdx] != x) return -1;
        return mnIdx + 1;
    }
}