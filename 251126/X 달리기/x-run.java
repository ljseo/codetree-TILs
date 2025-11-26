import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        sc.close();

        int v = (int) Math.sqrt(X);

        if (v * v == X) {
            System.out.println(2 * v - 1);
        } else if (X <= v * v + v) {
            System.out.println(2 * v);
        } else {
            System.out.println(2 * v + 1);
        }
    }
}
