import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        sc.close();

        int answer = -1;

        // top 행 ~ bottom 행 구간 선택
        for (int top = 0; top < N; top++) {
            boolean[] valid = new boolean[M];
            Arrays.fill(valid, true);

            for (int bottom = top; bottom < N; bottom++) {

                // 현재 행 bottom에서 양수인지 체크하여 valid 갱신
                for (int c = 0; c < M; c++) {
                    if (arr[bottom][c] <= 0) {
                        valid[c] = false;
                    }
                }

                // valid[]에서 연속 true 구간 최대 길이 찾기
                int height = bottom - top + 1;
                int currentLen = 0;

                for (int c = 0; c < M; c++) {
                    if (valid[c]) {
                        currentLen++;
                        answer = Math.max(answer, currentLen * height);
                    } else {
                        currentLen = 0;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
