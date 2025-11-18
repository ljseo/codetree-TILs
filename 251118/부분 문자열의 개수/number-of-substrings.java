import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();

        int cnt = 0;
        boolean flag = false;
        for(int i = 0; i<a.length()-b.length() + 1; i++){
            flag = true;;
            for(int j = 0; j<b.length(); j++){
                if(a.charAt(i+j) != b.charAt(j)){
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
        }
        System.out.println(cnt);
    }
}