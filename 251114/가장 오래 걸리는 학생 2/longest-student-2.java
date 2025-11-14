import java.util.*;
public class Main {

    static class Node{
        int index;
        int dist;
        public Node(int index, int dist){
            this.index = index;
            this.dist = dist;
        }
    }
    static class Element implements Comparable<Element>{
        int dist;
        int index;
        public Element(int dist, int index){
            this.dist = dist;
            this.index = index;
        }

        @Override
        public int compareTo(Element e){
            return this.dist - e.dist;
        }
    }

    static final int MAX_N = 100000;
    static int n,m;
    static ArrayList<Node>[] graph = new ArrayList[MAX_N+1];
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static int[] dist = new int[MAX_N+1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for(int i = 1; i<=n; i++){
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();

            graph[b].add(new Node(a,d));
        }

        Arrays.fill(dist, (int) 1e9);
        dist[n] = 0;
        pq.add(new Element(0,n));

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
        int ans = 0;

        for(int i = 1; i<=n; i++){
            ans = Math.max(ans, dist[i]);
        }
        System.out.print(ans);
    }
}