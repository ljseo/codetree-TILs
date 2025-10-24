import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] A = new int[N];
        for (int i = 0; i < N; i++)
            A[i] = sc.nextInt();
        int[] B = new int[M];
        for (int i = 0; i < M; i++)
            B[i] = sc.nextInt();
        // Please write your code here.

        int[] cntA = new int[101];
        int[] cntB = new int[101];
        for(int b : B){
            cntB[b]++;
        }

        int cnt = 0;
        for(int i = 0; i<=N-M; i++){
            for(int j = i; j < i+M; j++){
                cntA[A[j]]++;
            }
            boolean flag = true;
            for(int k = 0; k<101; k++){
                if(cntA[k] != 0 && cntA[k] != cntB[k]) {
                    flag = false;
                    break;
                }
            }
            if(flag) cnt++;
            Arrays.fill(cntA, 0);
        }
        System.out.println(cnt);
    }
}