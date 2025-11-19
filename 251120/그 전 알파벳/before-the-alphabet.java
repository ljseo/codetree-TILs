import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char a = sc.next().charAt(0);
        System.out.print(a == 'a' ? 'z' : (char)(a-1));
    }
}