import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        int cnt = 0;
        for(int i = 0; i<str.length(); i++){
            if(str.charAt(i) == '('){
                for(int j = i+1; j<str.length(); j++){
                    if(str.charAt(j) == ')') cnt++;
                }
            }
        }
        System.out.print(cnt);
    }
}