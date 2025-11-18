import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ss = s;

        int eeCnt = 0;
        int ebCnt = 0; 

        for(int i = 0; i<s.length()-1; i++){
            if(s.charAt(i) =='e' && s.charAt(i+1) == 'e') eeCnt++;
            if(s.charAt(i) =='e' && s.charAt(i+1) == 'b') ebCnt++;
        }
        System.out.print(eeCnt + " " + ebCnt);


    }
}