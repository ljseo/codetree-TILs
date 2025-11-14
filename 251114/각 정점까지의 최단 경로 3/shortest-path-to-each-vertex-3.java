import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] graph = new int[n+1][n+1];
        int [] dist = new int[n+1];
        boolean [] vis = new boolean[n+1];

        Arrays.fill(dist, (int)1e9);

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u][v] = w;
        }

        dist[1] = 0;

        for(int i = 1; i<=n; i++){
            int minIdx = -1;
            for(int j = 1; j<=n;j++){
                if(vis[j])continue;
                if(minIdx == -1 || dist[j] < dist[minIdx]){
                    minIdx = j;
                }
            }
            vis[minIdx] = true;
            for(int j = 1; j<=n; j++){
                if(graph[minIdx][j] == 0) continue;
                dist[j] = Math.min(dist[j], dist[minIdx] + graph[minIdx][j]);
            }
        }
        for(int i = 2; i<=n; i++){
            System.out.println(dist[i]);
        }
    }
}