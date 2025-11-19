import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int aIdx = 0;
        for(int i = 0; i < a.length(); i++){
            if(!Character.isDigit(a.charAt(i))) aIdx = i;
        }
        int bIdx = 0;
        for(int i = 0; i < b.length(); i++){
            if(!Character.isDigit(b.charAt(i))) bIdx = i;
        }
        int aa = Integer.parseInt(a.substring(0,aIdx));
        int bb = Integer.parseInt(b.substring(0,bIdx));
        System.out.print(aa+bb);
    }
}