import java.util.*;
public class Main {
    static String[] arr = new String[201];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int cnt = 0;
        while(!s.equals("0")){
            arr[cnt] = s;
            cnt++;
            s = sc.next();
        }
        System.out.println(cnt);
        for(int i = 0; i < cnt; i++){
            if(i % 2 == 0) System.out.println(arr[i]);
        }
    }
}