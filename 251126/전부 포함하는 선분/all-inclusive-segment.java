import java.util.*;

public class Main {

    static class Seg {
        int l, r;
        Seg(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        Seg[] segs = new Seg[N];

        for (int i = 0; i < N; i++) {
            int x1 = sc.nextInt();
            int x2 = sc.nextInt();
            segs[i] = new Seg(x1, x2);
        }
        sc.close();

        int answer = Integer.MAX_VALUE;

        // i번째 선분을 제거해본다
        for (int i = 0; i < N; i++) {
            int minL = Integer.MAX_VALUE;
            int maxR = Integer.MIN_VALUE;

            for (int j = 0; j < N; j++) {
                if (j == i) continue;
                minL = Math.min(minL, segs[j].l);
                maxR = Math.max(maxR, segs[j].r);
            }

            answer = Math.min(answer, maxR - minL);
        }

        System.out.println(answer);
    }
}
