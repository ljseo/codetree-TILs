import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

class Marble {
    int id;      // 구슬 번호 (입력 순서, 1부터 시작)
    int r, c;    // 위치
    int d;       // 방향 (0:U, 1:D, 2:R, 3:L)
    int w;       // 무게

    public Marble(int id, int r, int c, int d, int w) {
        this.id = id;
        this.r = r;
        this.c = c;
        this.d = d;
        this.w = w;
    }
}

public class Main {
    static int N, M, T;
    // 상(U), 하(D), 우(R), 좌(L) 순서 (방향 전환 처리를 위해 U<->D, R<->L 배치)
    // 0: U, 1: D, 2: R, 3: L
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNext()) return;

        N = sc.nextInt();
        M = sc.nextInt();
        T = sc.nextInt();

        ArrayList<Marble> marbles = new ArrayList<>();
        for (int i = 1; i <= M; i++) {
            int r = sc.nextInt() - 1; // 0-based index로 변환
            int c = sc.nextInt() - 1;
            char dChar = sc.next().charAt(0);
            int w = sc.nextInt();
            
            int d = getDir(dChar);
            marbles.add(new Marble(i, r, c, d, w));
        }

        // T초 동안 시뮬레이션 진행
        for (int t = 0; t < T; t++) {
            simulate(marbles);
        }

        // 결과 계산
        int maxWeight = 0;
        for (Marble m : marbles) {
            maxWeight = Math.max(maxWeight, m.w);
        }

        System.out.println(marbles.size() + " " + maxWeight);
        sc.close();
    }

    // 시뮬레이션 1회 수행
    static void simulate(ArrayList<Marble> marbles) {
        // 이동 후 구슬들을 담을 임시 격자 (각 칸에 구슬 리스트 저장)
        ArrayList<Marble>[][] nextGrid = new ArrayList[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                nextGrid[i][j] = new ArrayList<>();
            }
        }

        // 1. 모든 구슬 이동
        for (Marble m : marbles) {
            int nr = m.r + dr[m.d];
            int nc = m.c + dc[m.d];

            // 격자를 벗어나는 경우 (벽 충돌)
            if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
                // 위치는 유지, 방향 반전
                // 0(U)<->1(D), 2(R)<->3(L) : XOR 1 연산 혹은 조건문 사용
                int nextDir = (m.d % 2 == 0) ? m.d + 1 : m.d - 1;
                m.d = nextDir;
                // 위치는 그대로 m.r, m.c
                nextGrid[m.r][m.c].add(m);
            } else {
                // 정상 이동
                m.r = nr;
                m.c = nc;
                nextGrid[nr][nc].add(m);
            }
        }

        // 2. 충돌 처리 (한 칸에 여러 구슬이 있는 경우 합치기)
        ArrayList<Marble> nextMarblesList = new ArrayList<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (nextGrid[i][j].isEmpty()) continue;
                
                if (nextGrid[i][j].size() == 1) {
                    nextMarblesList.add(nextGrid[i][j].get(0));
                } else {
                    // 충돌 발생: 합체 로직
                    int sumWeight = 0;
                    Marble bestMarble = nextGrid[i][j].get(0);
                    
                    for (Marble m : nextGrid[i][j]) {
                        sumWeight += m.w;
                        
                        // 대표 구슬 선정 기준: 무게 > 번호
                        if (m.w > bestMarble.w) {
                            bestMarble = m;
                        } else if (m.w == bestMarble.w) {
                            if (m.id > bestMarble.id) {
                                bestMarble = m;
                            }
                        }
                    }
                    
                    // 대표 구슬의 정보(방향, 위치 등)를 유지하되 무게만 합산
                    bestMarble.w = sumWeight;
                    nextMarblesList.add(bestMarble);
                }
            }
        }
        
        // 구슬 리스트 갱신
        marbles.clear();
        marbles.addAll(nextMarblesList);
    }

    // 문자를 숫자 방향으로 변환
    static int getDir(char c) {
        if (c == 'U') return 0;
        if (c == 'D') return 1;
        if (c == 'R') return 2;
        return 3; // L
    }
}