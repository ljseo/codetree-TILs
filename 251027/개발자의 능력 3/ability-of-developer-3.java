import java.util.Scanner;

public class Main {
    static final int MAX_SUM = 10_000_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ability = new int[6];
        int total  = 0;
        for (int i = 0; i < 6; i++) {
            ability[i] = sc.nextInt();
            total += ability[i];
        }

        int sum = 0;
        int mn = MAX_SUM;
        for(int i = 0; i<6; i++){
            sum = 0;
            for(int j = i+1; j<6; j++){
                for(int k = j+1; k<6; k++){
                    sum = ability[i] + ability[j] + ability[k];
                    mn = Math.min(mn, Math.abs((total - sum) - sum));
                }
            }
        }
        System.out.println(mn);
    }
}