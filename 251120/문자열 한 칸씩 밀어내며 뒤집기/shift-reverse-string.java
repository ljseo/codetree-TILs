import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int q = sc.nextInt();
        while(q-->0){
            int oper = sc.nextInt();
            if(oper == 1) {
                s = s.substring(1) + s.substring(0,1);
            }
            else if(oper == 2){
                s = s.substring(s.length()-1) + s.substring(0,s.length()-1);
            }
            else{
                StringBuilder sb = new StringBuilder(s);
                s = sb.reverse().toString();
            }
            System.out.println(s);
        }
    }
}