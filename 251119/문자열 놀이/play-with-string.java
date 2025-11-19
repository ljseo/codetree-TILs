import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int q = sc.nextInt();
        while(q-->0){
            int order = sc.nextInt();
            if(order == 1){
                int a = sc.nextInt();
                int b = sc.nextInt();
                System.out.println(a + " " + b);
                char ca = s.charAt(a);
                char cb = s.charAt(b);
                s = s.substring(0,a) + cb + s.substring(a+1, s.length());
                s = s.substring(0,b) + ca + s.substring(b+1, s.length());
                System.out.println(s);
            }
            else{
                char x = sc.next().charAt(0);
                char y = sc.next().charAt(0);
                char [] arr = s.toCharArray();
                for(int i = 0; i<arr.length; i++){
                    if(arr[i] == x) arr[i] = y;
                    else if(arr[i] == y) arr[i] = x;
                }
                s = String.valueOf(arr);
                System.out.println(s);
            }
        }
    }
}