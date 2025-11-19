import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        char[] arr = s.toCharArray();
        arr[1] = 'a';
        arr[arr.length-2] = 'a';
        System.out.print(String.valueOf(arr));

    }
}