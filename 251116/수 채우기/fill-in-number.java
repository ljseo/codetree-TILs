import java.util.Scanner;
public class Main {

    static final int MAX_NUM = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = MAX_NUM;
        for(int i = 0; i<MAX_NUM; i++){
            int remainder = n - i * 5;
            if(remainder >= 0 && remainder % 2 == 0){
                ans = Math.min(ans,i + remainder / 2);
            }
        }
        if(ans == MAX_NUM) ans = -1;
        System.out.println(ans);
        
    }
}