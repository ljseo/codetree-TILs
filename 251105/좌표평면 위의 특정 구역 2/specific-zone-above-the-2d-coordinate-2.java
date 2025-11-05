import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }

        int res = Integer.MAX_VALUE;
        for(int i = 0; i<N; i++){
            int mnX = 50000;
            int mxX = 0;
            int mnY = 50000;
            int mxY = 0;
            for(int j = 0; j<N;j++){
                if(i == j) continue;
                mnX = Math.min(mnX, x[j]);
                mxX = Math.max(mxX, x[j]);
                mnY = Math.min(mnY, y[j]);
                mxY = Math.max(mxY, y[j]);
            }
            int area = (mxX - mnX) * (mxY - mnY);
            res = Math.min(res, area);
        }
        System.out.println(res);
    }
}