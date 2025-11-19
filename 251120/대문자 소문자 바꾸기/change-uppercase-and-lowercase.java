import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        for(int i = 0; i < len; i++){
            if(Character.isUpperCase(s.charAt(i))){
                System.out.print((char)(s.charAt(i) - 'A' + 'a'));
            }
            if(Character.isLowerCase(s.charAt(i))){
                System.out.print((char)(s.charAt(i) - 'a' + 'A'));
            }
        }
    }
}