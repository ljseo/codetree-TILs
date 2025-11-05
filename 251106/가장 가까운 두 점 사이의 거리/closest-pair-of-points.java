import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] x = new int[n];
        int[] y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        double distance = Integer.MAX_VALUE;

        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                int xDiff = Math.abs(x[i] - x[j]);
                int yDiff = Math.abs(y[i] - y[j]);
                double d = Math.pow(xDiff,2) + Math.pow(yDiff,2);
                if(distance > d){
                    distance = d;
                }
            }
        }
        System.out.println((int)distance);
    }
}