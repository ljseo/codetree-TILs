import java.util.*;
public class Main {

    static final int MAX_N = 100000;
    static int [] cards = new int[MAX_N+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            cards[bCards[i]] = 1;
        }

        int smallCnt = 0;
        int ans = 0;
        for(int i = 1; i<= 2*n; i++){
            if(cards[i] == 1){
                if(smallCnt > 0) ans++;
            } 
            else {
                smallCnt++;
            }
        }
        System.out.print(ans);
    }
}