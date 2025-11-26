import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        int[] arr = new int[N + 1]; // 1-indexed 배열
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int maxSum = 0;
        
        // 모든 시작 위치를 시도
        for (int start = 1; start <= N; start++) {
            int sum = 0;
            int currentPos = start;
            
            // M번 움직임 수행
            for (int move = 0; move < M; move++) {
                int value = arr[currentPos];
                sum += value;
                currentPos = value; // 원소값을 다음 위치로
            }
            
            maxSum = Math.max(maxSum, sum);
        }
        
        System.out.println(maxSum);
    }
}