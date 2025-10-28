import java.util.Scanner;

public class Main {
    static final int MAX_K = 1_000_000_000;
    static long n,k;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextLong();
        k = sc.nextLong();
        
        long left = 1;
        long right = n*n;
        long mn = n*n;
        while(left <= right){
            long mid = (left + right) / 2;

            long cnt = getCnt(mid);
            if(cnt >= k){
                right = mid - 1;
                mn = mid;
            }
            else{
                left = mid +1 ;
            }
        
        }
        System.out.println(mn);
    }
    static long getCnt(long x){
        long cnt = 0;
        for(int i = 1; i<=n; i++){
            cnt += Math.min(x/i, n);
        }
        return cnt;
    }
}