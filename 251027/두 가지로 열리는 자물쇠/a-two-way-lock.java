import java.util.Scanner;

public class Main {
    static final int MAX_N = 10;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int a2 = sc.nextInt();
        int b2 = sc.nextInt();
        int c2 = sc.nextInt();
        
        int cnt = 0;
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                for(int k = 1; k<=n; k++){
                    int first = Math.min(((i - a + n) % n), (a - i + n) % n);
                    int second = Math.min(((j - b + n) % n), (b - j + n) % n);
                    int third = Math.min(((k - c + n) % n), (c - k + n) % n);
                    int first2 = Math.min(((i - a2 + n) % n), (a2 - i + n) % n);
                    int second2 = Math.min(((j - b2 + n) % n), (b2 - j + n) % n);
                    int third2 = Math.min(((k - c2 + n) % n), (c2 - k + n) % n);;

                    if((first<=2 && second<=2 && third <= 2) || (first2 <= 2 && second2 <= 2 && third2 <=2)) {
                        cnt++;     
                    }
                }
            }
        }
        System.out.print(cnt);
    }
}