import java.util.Scanner;

public class Main {

    static long m,a,b;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextLong();
        a = sc.nextLong();
        b = sc.nextLong();
        int mn = Integer.MAX_VALUE;
        int mx = -1;
        for(long i = a; i<=b; i++){
            int cnt = getCnt(i);
            mn = Math.min(mn, cnt);
            mx = Math.max(mx, cnt);
        }
        System.out.println(mn + " " + mx);
    }
    static int getCnt(long x){
        long left = 1;
        long right = m; 
        int cnt = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            if(mid == x) return ++cnt;
            if(mid > x) right = mid - 1;
            else left = mid + 1;
            cnt++; 
        }
        return -1;
    }
}