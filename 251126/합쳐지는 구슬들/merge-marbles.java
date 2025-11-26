import java.util.*;

public class Main {
    static int N, M, T;
    static int[] dr = {-1, 1, 0, 0}; // U, D, R, L
    static int[] dc = {0, 0, 1, -1};
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();
        
        // 구슬 정보: {행, 열, 방향, 무게, 번호, 생존여부}
        int[][] marbles = new int[M][6];
        
        for (int i = 0; i < M; i++) {
            marbles[i][0] = sc.nextInt(); // r
            marbles[i][1] = sc.nextInt(); // c
            char d = sc.next().charAt(0);
            marbles[i][2] = getDir(d);    // 방향
            marbles[i][3] = sc.nextInt(); // 무게
            marbles[i][4] = i + 1;        // 번호 (1부터 시작)
            marbles[i][5] = 1;            // 생존
        }
        
        // T초 동안 시뮬레이션
        for (int t = 0; t < T; t++) {
            // 1. 모든 구슬 이동
            for (int i = 0; i < M; i++) {
                if (marbles[i][5] == 0) continue; // 사라진 구슬
                
                int r = marbles[i][0];
                int c = marbles[i][1];
                int d = marbles[i][2];
                
                int nr = r + dr[d];
                int nc = c + dc[d];
                
                // 벽에 부딪히면 방향 반전
                if (nr < 1 || nr > N || nc < 1 || nc > N) {
                    marbles[i][2] = reverseDir(d);
                    // 위치는 그대로 (방향만 바뀜)
                } else {
                    marbles[i][0] = nr;
                    marbles[i][1] = nc;
                }
            }
            
            // 2. 충돌 처리 (같은 위치에 있는 구슬들 합치기)
            mergeMarbles(marbles);
        }
        
        // 결과 계산
        int count = 0;
        int maxWeight = 0;
        for (int i = 0; i < M; i++) {
            if (marbles[i][5] == 1) {
                count++;
                maxWeight = Math.max(maxWeight, marbles[i][3]);
            }
        }
        
        System.out.println(count + " " + maxWeight);
    }
    
    static void mergeMarbles(int[][] marbles) {
        // 위치별로 구슬 그룹화
        Map<Long, List<Integer>> posMap = new HashMap<>();
        
        for (int i = 0; i < M; i++) {
            if (marbles[i][5] == 0) continue;
            long key = marbles[i][0] * 100L + marbles[i][1];
            posMap.computeIfAbsent(key, k -> new ArrayList<>()).add(i);
        }
        
        // 같은 위치에 2개 이상이면 합치기
        for (List<Integer> group : posMap.values()) {
            if (group.size() < 2) continue;
            
            // 가장 큰 번호를 가진 구슬 찾기
            int maxNumIdx = group.get(0);
            for (int idx : group) {
                if (marbles[idx][4] > marbles[maxNumIdx][4]) {
                    maxNumIdx = idx;
                }
            }
            
            // 무게 합산 및 나머지 구슬 제거
            int totalWeight = 0;
            for (int idx : group) {
                totalWeight += marbles[idx][3];
                if (idx != maxNumIdx) {
                    marbles[idx][5] = 0; // 제거
                }
            }
            marbles[maxNumIdx][3] = totalWeight;
        }
    }
    
    static int getDir(char c) {
        switch (c) {
            case 'U': return 0;
            case 'D': return 1;
            case 'R': return 2;
            case 'L': return 3;
        }
        return -1;
    }
    
    static int reverseDir(int d) {
        if (d == 0) return 1; // U -> D
        if (d == 1) return 0; // D -> U
        if (d == 2) return 3; // R -> L
        return 2;             // L -> R
    }
}