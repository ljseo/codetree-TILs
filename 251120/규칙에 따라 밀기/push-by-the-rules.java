import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String oper = sc.next();
        char[] operArr = oper.toCharArray();
        for(int i = 0; i<operArr.length; i++){
            if(operArr[i] == 'L'){
                s = s.substring(1) + s.substring(0,1);
            }
            else{
                s = s.substring(s.length()-1) + s.substring(0,s.length()-1);
            }
        }
        System.out.println(s);
    }
}