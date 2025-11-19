import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        int n = 0;

        for(int i = 0; i < a.length(); i++){
            if(a.equals(b)) {
                break;
            }
            else{
                a = a.substring(a.length()-1) + a.substring(0, a.length()-1);
                n++;
            }
        }
        System.out.print(a.equals(b) ? n : -1);
    }
}