import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 1; i < 11; i++){
            String s = sc.next();
            if(i % 2 == 1) System.out.println(s);
        }
    }
}