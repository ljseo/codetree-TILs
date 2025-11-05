import java.util.Scanner;
public class Main {
    static final int MAX_TOTAL = 3000;
    static final int MAX_N = 5;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] ability = new int[MAX_N];
        int total = 0;
        for(int i = 0; i<5; i++){
            ability[i] = sc.nextInt();
            total += ability[i];
        }

        int mn = MAX_TOTAL;

        for(int i = 0; i<MAX_N; i++){
            for(int j = i + 1; j<MAX_N; j++){
                for(int k = 0; k < MAX_N; k++){
                    for(int l = k + 1; l<MAX_N; l++){
                        if(i == k || i == l || j== k || j == l) continue;
                        int first = ability[i] + ability[j];
                        int second = ability[k] + ability[l];
                        int third = total - first - second;
                        if(first == second || second == third || third == first) continue;
                        mn = Math.min(mn, Math.max(first, Math.max(second, third)) - Math.min(first,Math.min(second, third)));
                    }
                }
            }
        }
        if(mn == MAX_TOTAL) mn = -1;
        System.out.println(mn);

    }
}