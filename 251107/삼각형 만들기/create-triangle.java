import java.util.Scanner;
public class Main {
    static int[] x,y;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int maxArea = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j + 1; k<n; k++){
                    if((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) 
                    && (y[i] == y[j] || y[i] == y[k] || y[j] == y[k])){
                        maxArea = Math.max(maxArea, getArea(i,j,k));
                    }
                }
            }
        }
        System.out.println(maxArea);
    }
    static int getArea(int i, int j, int k){
        return Math.abs((x[i] * y[j] + x[j] * y[k] + x[k] * y[i])
        -(y[i] * x[j] + y[j] * x[k] + y[k] * x[i]));
    }
}