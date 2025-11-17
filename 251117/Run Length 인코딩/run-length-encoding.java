import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        int len = a.length();
        char c = a.charAt(0);
        int cnt = 1;
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < len; i++){
            if(a.charAt(i) != c){
                sb.append(c).append(cnt);
                c = a.charAt(i);
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        sb.append(c).append(cnt);

        System.out.println(sb.length() + "\n" + sb);
    }
}