import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] grid;
    
    // 방향: 0=상, 1=우, 2=하, 3=좌
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        grid = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int maxTime = 0;
        
        // 모든 시작점 시도 (4*N개)
        // 위쪽 가장자리에서 아래로
        for (int c = 0; c < N; c++) {
            maxTime = Math.max(maxTime, simulate(-1, c, 2)); // 하
        }
        
        // 아래쪽 가장자리에서 위로
        for (int c = 0; c < N; c++) {
            maxTime = Math.max(maxTime, simulate(N, c, 0)); // 상
        }
        
        // 왼쪽 가장자리에서 오른쪽으로
        for (int r = 0; r < N; r++) {
            maxTime = Math.max(maxTime, simulate(r, -1, 1)); // 우
        }
        
        // 오른쪽 가장자리에서 왼쪽으로
        for (int r = 0; r < N; r++) {
            maxTime = Math.max(maxTime, simulate(r, N, 3)); // 좌
        }
        
        System.out.println(maxTime);
    }
    
    static int simulate(int startR, int startC, int dir) {
        int r = startR;
        int c = startC;
        int time = 0;
        
        // 무한 루프 방지 (최대 2*N*N 이동)
        int maxSteps = 2 * N * N;
        
        while (maxSteps-- > 0) {
            // 다음 위치로 이동
            r += dr[dir];
            c += dc[dir];
            time++;
            
            // 격자 밖으로 나가면 종료
            if (r < 0 || r >= N || c < 0 || c >= N) {
                return time;
            }
            
            // 바에 부딪히면 방향 전환
            if (grid[r][c] == 1) { // /
                dir = reflectSlash(dir);
            } else if (grid[r][c] == 2) { // \
                dir = reflectBackslash(dir);
            }
        }
        
        return time; // 무한 루프면 현재 시간 반환
    }
    
    // / 모양에서 반사
    static int reflectSlash(int dir) {
        // 상(0) <-> 우(1), 하(2) <-> 좌(3)
        if (dir == 0) return 1; // 상 -> 우
        if (dir == 1) return 0; // 우 -> 상
        if (dir == 2) return 3; // 하 -> 좌
        if (dir == 3) return 2; // 좌 -> 하
        return dir;
    }
    
    // \ 모양에서 반사
    static int reflectBackslash(int dir) {
        // 상(0) <-> 좌(3), 하(2) <-> 우(1)
        if (dir == 0) return 3; // 상 -> 좌
        if (dir == 1) return 2; // 우 -> 하
        if (dir == 2) return 1; // 하 -> 우
        if (dir == 3) return 0; // 좌 -> 상
        return dir;
    }
}