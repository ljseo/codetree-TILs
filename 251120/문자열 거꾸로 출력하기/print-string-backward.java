import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        while(!s.equals("END")){
            char[] arr = s.toCharArray();
            for(int i = 0; i < arr.length/2; i++){
                char temp = arr[i];
                arr[i] = arr[arr.length - 1 - i];
                arr[arr.length - 1 - i] = temp;
            }
            System.out.println(String.valueOf(arr));
            s = sc.next();
        }
    }
}