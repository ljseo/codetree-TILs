import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int len = s.length();
        int sum = 0;
        for(int i = 0; i < len; i++){
            if(Character.isDigit(s.charAt(i))){
                sum += s.charAt(i) - '0';
            }
        }
        System.out.print(sum);
    }
}