import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long s = sc.nextLong();
        // Please write your code here.

        System.out.println(getMXN(s));
    }
    static long getMXN(Long x){
        long left = 0;
        long right = x;
        long mx = -1;
        while(left <= right){
            long mid = (left + right) / 2;
            if(mid * (mid + 1) / 2 <= x){
                mx = Math.max(mx, mid);
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        return mx;
    }
}