import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int t = sc.nextInt();
        int[] top = new int[n];
        int[] bottom = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = sc.nextInt();
        }
        for (int i = 0; i < n; i++) {
            bottom[i] = sc.nextInt();
        }
        while(t-->0){
            int temp = top[top.length-1];
            for(int i = n-1; i > 0; i--){
                top[i] = top[i-1];
            }
            top[0] = bottom[n-1];
            for(int i = n-1; i > 0; i--){
                bottom[i] = bottom[i-1];
            }
            bottom[0] = temp;
        }
        for(int i = 0; i < n; i++){
            System.out.print(top[i] + " ");
        }
        System.out.println();
        for(int i = 0; i < n; i++){
            System.out.print(bottom[i] + " ");
        }
    }
}