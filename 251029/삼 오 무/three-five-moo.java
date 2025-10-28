import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long left = 1;
        long right = 2_000_000_000;
        long k = 2_000_000_000;
        while(left <= right){
            long mid = (left + right) / 2;
            long seq = getSeq(mid);
            if(seq >= n){
                right = mid - 1;
                k = mid;
            }
            else left = mid + 1;
        }
        System.out.print(k);
    }
    static long getSeq(long n){
        long sum = n/3 + n/5 - n/15;
        return n - sum;
    }
}