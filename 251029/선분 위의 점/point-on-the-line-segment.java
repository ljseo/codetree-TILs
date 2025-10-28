import java.util.Scanner;
/*
a: 시작점보다 작으면서 가장 큰 점을 찾고, 없으면 -1
b : 끝점보다 크면서 가장 작은 점을 찾는다 없으면 n 
b-a-1;
*/
public class Main {
    static final int MAX_N = 1_000_000;
    static int[] arr = new int[MAX_N];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int a, b;
        for (int i = 0; i < m; i++) {
            a = sc.nextInt();
            b = sc.nextInt();

            int start = findStart(a);
            int end = findEnd(b);
            System.out.println(end - start - 1);

        }
    }
    static int findStart(int x){
        int left = 0;
        int right = n-1;
        int mxIdx = -1;

        while(left <= right){
            int mid = (left + right) / 2;

            if(arr[mid] < x){
                left = mid + 1;
                mxIdx = Math.max(mxIdx, mid);
            }
            else{
                right = mid - 1;
            }

        }
        return mxIdx;
    }
    static int findEnd(int x){
        int left = 0;
        int right = n-1;
        int mnIdx = n;
        while(left <= right){
            int mid = (left + right) / 2;
            if(arr[mid] > x){
                right = mid - 1;
                mnIdx = Math.min(mid,mnIdx);
            }
            else{
                left = mid + 1;
            }
        }
        return mnIdx;
    }
}