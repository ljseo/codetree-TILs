import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] l = new int[n];
        int[] r = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            l[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            r[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            d[i] = sc.nextInt();
        }
        while(t-->0){
            int temp = l[n-1];
            for(int i = n-1; i > 0; i--){
                l[i] = l[i-1];
            }
            l[0] = d[n-1];
            for(int i = n-1; i > 0; i--){
                d[i] = d[i-1];
            }
            d[0] = r[n-1];
            for(int i = n-1; i > 0; i--){
                r[i] = r[i-1];
            }
            r[0] = temp;
        }
        for(int a : l){
            System.out.print(a + " ");
        }
        System.out.println();
        for(int a : r){
            System.out.print(a + " ");
        }
        System.out.println();
        for(int a : d){
            System.out.print(a + " ");
        }
    }
}