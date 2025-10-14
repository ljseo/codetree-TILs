import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.

        System.out.print(toMin(c,d) - toMin(a,b));



    }
    static int toMin(int h, int m){
        return h * 60 + m;
    }
}