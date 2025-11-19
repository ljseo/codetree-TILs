import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        int len = arr.length;
        for(int i = 0; i < len; i++){
            char c = arr[i];
            if(c >= 'A' && c <= 'Z'){
                System.out.print((char)(c - 'A' + 'a'));
            }
            else if(c >= 'a' && c <= 'z'){
                System.out.print(c);
            }
            else if(c >= '0' && c <= '9'){
                System.out.print(c);
            }
        }
    }
}