import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int aCnt = 0;
        int lenSum = 0;
        for(int i =0; i<n; i++){
            String str = sc.next();
            lenSum += str.length();
            if(str.charAt(0) == 'a') aCnt++;
        }
        System.out.print(lenSum + " " + aCnt);
    }
}