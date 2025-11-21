import java.util.*;

public class Main {

    static int n;
    static int ans;
    static int[] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        ans = 0;
        createSeq(0);
        System.out.println(ans);
    }
    static void createSeq(int cnt){
        if(cnt == n){
            if(check()) ans++;
            return;
        }
        for(int i = 1; i <= 4; i++){
            arr[cnt] = i;
            createSeq(cnt+1);
        }
    }
    static boolean check(){

        int cnt = 1;
        for(int i = 1; i < n; i++){
            if(arr[i] != arr[i-1]){
                int num = arr[i-1];
                if((cnt % num) != 0 ) return false;
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        int num = arr[n-1];
        if((cnt % num) != 0) return false;
        return true;
    }
}
