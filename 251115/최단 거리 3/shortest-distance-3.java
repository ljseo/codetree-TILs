import java.util.*;
import java.io.*;
/*
1. 정점과 간선이 주어진다  -> 그래프
2. 정점 A에서 정점 B까지의 최단 거리 -> 점 A에서 다익스트라 
3. 그래프는 양방향 그래프 
4. 정점 1000, 간선 100000 -> O(V^2) or O(ElogV) -> 아무거나 사용 비슷함 
-> 나는 인접리스트 사용 
*/
class Node {
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
    public Element(int dist, int index){
        this.dist = dist;
        this.index = index;
    }
    @Override
    public int compareTo(Element e){
        return dist - e.dist;
    }
}

public class Main {

    static final int MAX_N = 1000;
    static int [] dist = new int[MAX_N+1];
    static PriorityQueue<Element> pq = new PriorityQueue();
    static ArrayList<Node> [] graph = new ArrayList[MAX_N+1];
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();
            graph[u].add(new Node(v,w));
            graph[v].add(new Node(u,w));
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        
        Arrays.fill(dist, (int)1e9);
        dist[a] = 0;
        pq.add(new Element(0,a));
        while(!pq.isEmpty()){
            int mnIdx = pq.peek().index;
            int mnDist = pq.peek().dist;
            pq.poll();

            if(dist[mnIdx] != mnDist) continue;

            for(int i = 0; i<graph[mnIdx].size(); i++){
                int targetIdx = graph[mnIdx].get(i).index;
                int targetDist = graph[mnIdx].get(i).dist;
                if(dist[mnIdx] + targetDist < dist[targetIdx]){
                    dist[targetIdx] = dist[mnIdx] + targetDist;
                    pq.add(new Element(dist[targetIdx], targetIdx));
                }
            }
        }
        System.out.println(dist[b]);
    }
}