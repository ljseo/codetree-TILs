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

        int area = 0;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j + 1; k<n; k++){
                    if((x[i] == x[j] || x[i] == x[k] || x[j] == x[k]) 
                    && (y[i] == y[j] || y[i] == y[k] || y[j] == y[k])){
                        int getA = getArea(i,j,k);
                        if(getA >= area){
                            //System.out.println("i: " + i + " j: " + j +" k: " + k +" area: " + getA);
                            area = getA;
                        }
                        //area = Math.max(area, getArea(i,j,k));
                    }
                }
            }
        }
        System.out.println(area);
    }
    static int getArea(int a, int b, int c){
        int first = (x[b] - x[a]) * (y[c] - y[a]);
        int second = (x[c] - x[a]) * (y[b] - y[a]);

        return Math.abs(first - second);
    }
}