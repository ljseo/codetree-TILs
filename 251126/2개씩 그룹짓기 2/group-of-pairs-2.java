import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // N 입력
        int n = sc.nextInt();

        // 2N개의 정수 배열 생성 및 입력
        int[] arr = new int[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = sc.nextInt();
        }

        // 1. 배열을 오름차순으로 정렬
        Arrays.sort(arr);

        // 최솟값 중 최대를 찾아야 하므로, 초기 minDiff는 매우 큰 값으로 설정
        int minDiff = Integer.MAX_VALUE;

        // 2. 인덱스 i와 i+n을 짝지어 차이 계산
        // 정렬된 상태에서 (작은 그룹의 i번째)와 (큰 그룹의 i번째)를 매칭하는 것이
        // 차이의 최솟값을 방어(최대화)하는 최적의 그리디 전략임
        for (int i = 0; i < n; i++) {
            int diff = arr[i + n] - arr[i];
            
            // 모든 쌍의 차이 중 가장 작은 값을 기록
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        // 결과 출력
        System.out.println(minDiff);

        sc.close();
    }
}