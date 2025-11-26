import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt();
        int[] arr = new int[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        // 이미 마지막 위치에 있는 경우
        if (n == 1) {
            System.out.println(0);
            return;
        }
        
        int jumps = 0;  // 점프 횟수
        int currentMax = 0;  // 현재 점프로 도달 가능한 최대 인덱스
        int nextMax = 0;  // 다음 점프로 도달 가능한 최대 인덱스
        
        for (int i = 0; i < n; i++) {
            // 현재 위치에 도달할 수 없는 경우
            if (i > currentMax) {
                System.out.println(-1);
                return;
            }
            
            // 다음 점프로 도달 가능한 최대 범위 갱신
            nextMax = Math.max(nextMax, i + arr[i]);
            
            // 이미 마지막 위치에 도달 가능한 경우
            if (nextMax >= n - 1) {
                System.out.println(jumps + 1);
                return;
            }
            
            // 현재 점프 범위의 끝에 도달한 경우
            if (i == currentMax) {
                jumps++;
                currentMax = nextMax;
            }
        }
        
        // 마지막 위치에 도달할 수 없는 경우
        System.out.println(-1);
        
        sc.close();
    }
}