import java.util.*;

class Bomb implements Comparable<Bomb>{
    int score;
    int timeLimit;
    public Bomb (int score, int timeLimit){
        this.score = score;
        this.timeLimit = timeLimit;
    }
    @Override
    public int compareTo(Bomb b){
        return timeLimit - b.timeLimit;
    }
}

public class Main {

    static final int MAX_T = 10000;
    static Bomb[] bombs;

    public static int getTimeLimit(int bombIdx) {
        int timeLimit = bombs[bombIdx].timeLimit;
    
        return timeLimit;
    }
    
    // 폭탄 번호가 주어졌을 때
    // 해당 폭탄 해체시 얻게 되는 점수를 반환합니다.
    public static int getScore(int bombIdx) {
        int score = bombs[bombIdx].score;
        
        return score;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        bombs = new Bomb[n];

        for(int i = 0; i<n; i++){
            int score = sc.nextInt();
            int timeLimit = sc.nextInt();
            bombs[i] = new Bomb(score, timeLimit);
        }
        Arrays.sort(bombs, 0, n);
        int bombIdx = n - 1;
        int ans = 0;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int t = MAX_T; t >= 1; t--) {
            // t초에 해체가 가능한 폭탄들을
            // 전부 우선순위 큐에 담아줍니다.
            while(bombIdx >= 0 && getTimeLimit(bombIdx) >= t) {
                pq.add(-getScore(bombIdx));
                bombIdx--;
            }

            // 현재 시간에 해체 가능한 폭탄이 존재한다면
            // 그 중 가장 높은 점수를 얻을 수 있는 폭탄을 해체해줍니다.
            if(!pq.isEmpty()) {
                ans += -pq.poll();
            }
        }

        System.out.print(ans);
    }
}
