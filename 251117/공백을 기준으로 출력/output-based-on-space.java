import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<s1.length(); i++){
            if(s1.charAt(i) != ' ') sb.append(s1.charAt(i));
        }
        for(int i = 0; i<s2.length(); i++){
            if(s2.charAt(i) != ' ') sb.append(s2.charAt(i));
        }
        System.out.print(sb);
    }
}