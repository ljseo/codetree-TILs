import java.util.Scanner;
public class Main {
    static final int MAX_TIME = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
            B[i] = sc.nextInt();
        }
        int mxWorkTime = 0;
        for(int i = 0; i<n; i++){
            int[] cnt = new int[MAX_TIME + 1];
            for(int j = 0; j<n; j++){    
                if(i == j) continue;
                for(int k = A[j]+1; k<=B[j]; k++){
                    cnt[k]++;
                }
            }

            int workTime = 0;
            for(int j = 0; j<MAX_TIME+1; j++){
                if(cnt[j] > 0) workTime++;
            }

            mxWorkTime = Math.max(mxWorkTime, workTime);
        }
        System.out.print(mxWorkTime);
    }
}