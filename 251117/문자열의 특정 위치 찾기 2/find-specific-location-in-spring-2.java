import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = new String[]{"apple", "banana", "grape", "blueberry", "orange"};
        int cnt = 0;
        char c = sc.next().charAt(0);
        for(int i =0; i<5; i++){
            if(str[i].charAt(2) == c|| str[i].charAt(3) == c){
                System.out.println(str[i]);
                cnt++;
            }
        }
        System.out.print(cnt);
    }
}