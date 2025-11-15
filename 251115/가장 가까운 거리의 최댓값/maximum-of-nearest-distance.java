import java.util.*;
import java.io.*;

/*
A,B,C를 제외한 나머지 정점들을 다익스트라 진행해서 
A,B,C까지의 최단 거리 중 최대를 구할 수 있음 
-> 하지만 이 경우 시간복잡도가 
O(V * E * log V) = O(100_000 * 100_000 * log100_000)

반대로 생각해서 A,B,C에서 다익스트라 진행해서 
A,B,C에서 각 정점까지의 최단 거리를 구함
이후 A,B,C에서 각 정점까지의 최단거리를 비교해서
최단거리 중 최댓값을 구함

1. dist 배열을 2차원 배열로 new int[3][MAX_N];
2. 다익스트라 알고리즘을 함수로 

-> 보통 배열을 static 변수로 선언 후 사용하기에 1번 방법 사용

*/
class Node{
    int index;
    int dist;
    public Node(int index, int dist){
        this.index = index;
        this.dist = dist;
    }
}
class Element implements Comparable<Element>{
    int dist;
    int index;
    public Element (int dist, int index){
        this.dist = dist;
        this.index = index;
    }
    @Override
    public int compareTo(Element e){
        return this.dist - e.dist;
    }

}
public class Main {

    static final int MAX_M = 100000;
    static final int MAX_N = 100000;
    static final int INF = (int)1e9;
    static final int NODE_NUM = 3;

    static ArrayList<Node>[] graph = new ArrayList[MAX_N+1];
    static int[][] dist = new int[NODE_NUM][MAX_N+1];
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int n,m;
    static int[] nodes = new int[NODE_NUM];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()); 
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i<NODE_NUM; i++){
            nodes[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i<=MAX_N; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i<m; i++){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v,w));
            graph[v].add(new Node(u,w));
        }

        for(int i = 0; i<NODE_NUM; i++){
            int n = nodes[i];
            Arrays.fill(dist[i], INF);
            pq = new PriorityQueue<>();
            dist[i][n] = 0;
            pq.add(new Element(0,n));
            while(!pq.isEmpty()){
                int mnIdx = pq.peek().index;
                int mnDist = pq.peek().dist;
                pq.poll();

                if(dist[i][mnIdx] != mnDist) continue;

                for(int j = 0; j<graph[mnIdx].size(); j++){
                    int targetIdx = graph[mnIdx].get(j).index;
                    int targetDist = graph[mnIdx].get(j).dist;
                    if(dist[i][mnIdx] + targetDist < dist[i][targetIdx]){
                        dist[i][targetIdx] = dist[i][mnIdx] + targetDist;
                        pq.add(new Element(dist[i][targetIdx], targetIdx));
                    }
                }
            }
        }
        int ans = -1;
        for(int i = 1; i<= MAX_N; i++){
            if(i == nodes[0] || i == nodes[1] || i == nodes[2]) continue;
            if(dist[0][i] == INF && dist[1][i] == INF && dist[2][i] == INF) continue;
            ans = Math.max(ans, Math.min(Math.min(dist[0][i], dist[1][i]), dist[2][i]));
        }
        System.out.print(ans);
        
    }
}