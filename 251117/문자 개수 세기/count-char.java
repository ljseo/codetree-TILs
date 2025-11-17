import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        char c = sc.next().charAt(0);
        int cnt = 0;
        for(char cc : s.toCharArray()){
            if (cc == c) cnt++;
        }
        System.out.print(cnt);

    }
}