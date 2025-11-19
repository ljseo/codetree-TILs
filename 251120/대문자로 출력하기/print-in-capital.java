import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        for(int i = 0; i<arr.length; i++){
            char c = arr[i];
            if(c >= 'A' && c <= 'Z'){
                System.out.print(arr[i]);
            }
            else if(c >= 'a' && c <= 'z'){
                System.out.print((char)(arr[i] - 'a' + 'A'));
            }
        }
    }
}