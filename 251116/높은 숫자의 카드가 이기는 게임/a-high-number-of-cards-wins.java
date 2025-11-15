import java.util.*;
public class Main {

    static final int MAX_N = 100000;
    static int [] cards = new int[MAX_N+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] bCards = new int[n];
        Arrays.fill(cards,1,2*n+1, 2);
        for (int i = 0; i < n; i++) {
            bCards[i] = sc.nextInt();
            cards[bCards[i]] = 1;
        }
        
        int cnt = 0;
        for(int i = 1; i<=MAX_N; i++){
            if(cards[i] == 1){
                for(int j = i+1; j<=MAX_N; j++){
                    if(cards[j] == 2) {
                        cards[j] = -1;
                        cnt++;
                        break;
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}