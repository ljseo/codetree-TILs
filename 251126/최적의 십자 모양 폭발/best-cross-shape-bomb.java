import java.util.*;

public class Main {
    static int N;
    static int[][] board;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        board = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                board[i][j] = sc.nextInt();
            }
        }

        int answer = 0;

        // 모든 칸을 중심으로 폭발을 시도
        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                answer = Math.max(answer, simulate(r, c));
            }
        }

        System.out.println(answer);
    }

    // 폭발 → 중력 → 쌍 세기 시뮬레이션
    static int simulate(int r, int c) {
        int[][] temp = copy(board);

        int power = temp[r][c];

        // 폭발: 중심 포함, 상하좌우 power-1칸
        temp[r][c] = 0;
        for (int d = 1; d <= power - 1; d++) {
            if (r - d >= 0) temp[r - d][c] = 0;
            if (r + d < N) temp[r + d][c] = 0;
            if (c - d >= 0) temp[r][c - d] = 0;
            if (c + d < N) temp[r][c + d] = 0;
        }

        applyGravity(temp);

        return countPairs(temp);
    }

    // 배열 복사
    static int[][] copy(int[][] arr) {
        int[][] ret = new int[N][N];
        for (int i = 0; i < N; i++) {
            ret[i] = arr[i].clone();
        }
        return ret;
    }

    // 중력 적용
    static void applyGravity(int[][] arr) {
        for (int col = 0; col < N; col++) {
            int write = N - 1;
            for (int row = N - 1; row >= 0; row--) {
                if (arr[row][col] != 0) {
                    arr[write][col] = arr[row][col];
                    if (write != row) arr[row][col] = 0;
                    write--;
                }
            }
            // 나머지는 0으로 채움
            for (int row = write; row >= 0; row--) {
                arr[row][col] = 0;
            }
        }
    }

    // 인접한 동일 숫자 쌍 세기
    static int countPairs(int[][] arr) {
        int count = 0;

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {

                // 오른쪽과 비교
                if (c + 1 < N && arr[r][c] == arr[r][c + 1] && arr[r][c] != 0)
                    count++;

                // 아래와 비교
                if (r + 1 < N && arr[r][c] == arr[r + 1][c] && arr[r][c] != 0)
                    count++;
            }
        }
        return count;
    }
}
