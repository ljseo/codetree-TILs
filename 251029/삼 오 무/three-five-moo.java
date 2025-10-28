import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();

        long left = 1;
        long right = 1_000_000_000;

        while(left <= right){
            long mid = (left + right) / 2;
            long seq = getSeq(mid);
            if(seq == n){
                System.out.println(mid);
                return;
            }
            if(seq > n) right = mid - 1;
            else left = mid + 1;
        }
    }
    static long getSeq(long n){
        long sum = n/3 + n/5 - n/15;
        return n - sum;
    }
}