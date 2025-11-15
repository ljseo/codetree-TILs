import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] prices = new int[n];
        for(int i = 0; i < n; i++)
            prices[i] = sc.nextInt();
        
        int currentPrice = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++){
            if(prices[i] <= currentPrice){
                currentPrice = prices[i];
            }
            else{
                ans = Math.max(ans, prices[i] - currentPrice);
            }
        }
        System.out.print(ans);

    }
}