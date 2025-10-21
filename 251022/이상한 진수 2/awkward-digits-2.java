import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String binary = sc.next();
        
        int zeroIndex = binary.indexOf('0');
        
        if (zeroIndex != -1) {
            binary = binary.substring(0, zeroIndex) + '1' + binary.substring(zeroIndex + 1);
        } else {
            binary = binary.substring(0, binary.length() - 1) + '0';
        }
        
        System.out.print(Integer.parseInt(binary, 2));
    }
}