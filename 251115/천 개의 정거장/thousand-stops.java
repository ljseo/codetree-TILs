import java.util.*;
import java.io.*;

class Pair{
    long cost;
    long time;
    public Pair(long cost, long time){
        this.cost = cost;
        this.time = time;
    }
    boolean isGreaterThan(Pair p){
        return this.cost > p.cost || (this.cost == p.cost && this.time > p.time);
    }
}


public class Main {

    static final int MAX_M = 1000; // 최대 지점 수 1000개 
    static final long INF = (long)1e17; // 버스의 비용 10^9, 정점의 수는 1000개 
    static int a,b,n;
    static Pair[][] graph = new Pair[MAX_M+1][MAX_M+1];
    static boolean[] visited = new boolean[MAX_M+1];
    static Pair[] dist = new Pair[MAX_M+1];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        for(int i = 1; i<=MAX_M; i++){
            for(int j = 1; j<=MAX_M; j++){
                graph[i][j] = new Pair(INF, 0);
            }
            graph[i][i] = new Pair(0,0);
        }


        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int stopNum = Integer.parseInt(st.nextToken());

            ArrayList<Integer> stops = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j<stopNum; j++){
                stops.add(Integer.parseInt(st.nextToken()));
            }
            for(int j = 0; j<stops.size(); j++){
                for(int k = j+1; k<stops.size(); k++){
                    Pair newP = new Pair(cost, k-j);
                    if(graph[stops.get(j)][stops.get(k)].isGreaterThan(newP)){
                        graph[stops.get(j)][stops.get(k)] = newP;
                    }
                }
            }
        }

        Arrays.fill(dist, new Pair(INF,0));
        dist[a] = new Pair(0,0);

        for(int i = 1; i<=MAX_M; i++){

            int mnIdx = -1;

            for(int j = 1; j<=MAX_M; j++){
                if(visited[j]) continue;
                if(mnIdx == -1 || dist[mnIdx].isGreaterThan(dist[j])){
                    mnIdx = j;
                }
            }

            visited[mnIdx] = true;

            for(int j = 1; j<=MAX_M; j++){
                Pair newP = new Pair(dist[mnIdx].cost + graph[mnIdx][j].cost, dist[mnIdx].time+graph[mnIdx][j].time);
                if(dist[j].isGreaterThan(newP)){
                    dist[j] = newP;
                }
            }

        }
        System.out.print(dist[b].cost == INF ? -1 +" "+ -1 : dist[b].cost + " "+ dist[b].time);
    }
}