import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        
        int aLen = a.length();
        int bLen = b.length();

        String aNum = "";
        for(int i = 0; i < aLen; i++){
            if(Character.isDigit(a.charAt(i))){
                aNum += a.charAt(i);
            }
        }
        String bNum = "";
        for(int i = 0; i < bLen; i++){
            if(Character.isDigit(b.charAt(i))){
                bNum += b.charAt(i);
            }
        }
        System.out.print(Integer.parseInt(aNum) + Integer.parseInt(bNum));
    }
}