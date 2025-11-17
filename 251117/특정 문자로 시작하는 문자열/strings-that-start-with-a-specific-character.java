import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] str = new String[n];
        for(int i = 0; i<n; i++){
            str[i] = sc.next();
        }
        char c = sc.next().charAt(0);
        int cnt = 0;
        int lenSum = 0;
        for(int i = 0; i<n; i++){
            if(str[i].charAt(0) == c) {
                lenSum += str[i].length();
                cnt++;
            }
        }
        System.out.printf("%d %.2f", cnt, (double)lenSum / cnt);
    }
}