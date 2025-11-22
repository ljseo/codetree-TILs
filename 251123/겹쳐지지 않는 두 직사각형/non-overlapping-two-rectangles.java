import java.util.*;

public class Main {

    static final int MAX_NM = 5;
    static int n,m;
    static int[][] grid = new int[MAX_NM][MAX_NM];
    static int mx = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                grid[i][j] = sc.nextInt();
            }
        }

         for (int r1 = 0; r1 < n; r1++) {
            for (int c1 = 0; c1 < m; c1++) {
                for (int r2 = r1; r2 < n; r2++) {
                    for (int c2 = c1; c2 < m; c2++) {
                        for (int r3 = 0; r3 < n; r3++) {
                            for (int c3 = 0; c3 < m; c3++) {
                                for (int r4 = r3; r4 < n; r4++) {
                                    for (int c4 = c3; c4 < m; c4++) {
                                    
                                        // 두 직사각형이 겹치지 않는다면 합 계산
                                        if (isNotOverlap(r1, c1, r2, c2, r3, c3, r4, c4)) {
                                            int sum1 = getSum(r1, c1, r2, c2);
                                            int sum2 = getSum(r3, c3, r4, c4);
                                            mx = Math.max(mx, sum1 + sum2);
                                        }
                                        
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        System.out.print(mx);
    }

    static int getSum(int r1, int c1, int r2, int c2) {
        int sum = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                sum += grid[i][j];
            }
        }
        return sum;
    }

    static boolean isNotOverlap(int r1, int c1, int r2, int c2, int r3, int c3, int r4, int c4) {

        return r2 < r3 || r1 > r4 || c2 < c3 || c1 > c4;

    }
}