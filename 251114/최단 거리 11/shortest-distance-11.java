import java.util.*;
public class Main {
    static final int MAX_N = 1000;
    
    static int n,m;
    static int[][] graph = new int[MAX_N+1][MAX_N+1];
    static int[] dist = new int[MAX_N+1];
    static boolean[] vis = new boolean[MAX_N+1];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            graph[x][y] = z;
            graph[y][x] = z;
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        Arrays.fill(dist, (int)1e9);
        dist[b] = 0;

        for(int i = 1; i<=n; i++){
            int mnIdx = -1;
            for(int j = 1; j<=n; j++){
                if(vis[j]) continue;
                if(mnIdx == -1 || dist[j] <dist[mnIdx]){
                    mnIdx = j;
                }
            }

            vis[mnIdx] = true;

            for(int j = 1; j<=n; j++){
                if(graph[mnIdx][j] == 0) continue;
                dist[j] = Math.min(dist[j], dist[mnIdx] + graph[mnIdx][j]);
            }
        }
        System.out.println(dist[a]);
        int x = a;
        ArrayList<Integer> path = new ArrayList<>();
        System.out.print(x + " ");
        while(x!=b){
            for(int i = 1; i <= n; i++) {
                if(graph[i][x] == 0)
                    continue;
   
                if(dist[i] + graph[i][x] == dist[x]) {
                    x = i;
                    break;
                }
            }
            System.out.print(x + " ");
        }
        
    }
}