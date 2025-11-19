import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        while(s.length() > 1){
            int a = sc.nextInt();
            if(s.length() < a){
                s = s.substring(0,s.length()-1);
            }
            else{
                s = s.substring(0,a) + s.substring(a+1);
            }
            System.out.println(s);
        }
    }
}