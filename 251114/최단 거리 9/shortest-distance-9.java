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

    static final int MAX_N = 1000;
    static int[] dist = new int[MAX_N+1];
    static int[] path = new int[MAX_N+1];
    static ArrayList<Node>[] graph = new ArrayList[MAX_N+1];
    static PriorityQueue<Element> pq = new PriorityQueue<>();
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

        Arrays.fill(dist, (int) 1e9);
        dist[a] = 0;
        pq.add(new Element(0, a));
        while(!pq.isEmpty()){
            int mnIdx = pq.peek().index;
            int mnDist = pq.peek().dist;
            pq.poll();

            if(mnDist != dist[mnIdx]) continue;

            for(int i = 0; i<graph[mnIdx].size(); i++){
                int targetIdx = graph[mnIdx].get(i).index;
                int targetDist = graph[mnIdx].get(i).dist;

                if(dist[mnIdx] + targetDist < dist[targetIdx]){
                    dist[targetIdx] = dist[mnIdx] + targetDist;
                    path[targetIdx] = mnIdx;
                    pq.add(new Element(dist[targetIdx], targetIdx));
                }
            }
        }

        List<Integer> vertices = new ArrayList<>();

        int x = b;
        while(x != a){
            vertices.add(x);
            x = path[x];
        }
        vertices.add(a);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[b]).append("\n");
        for(int i = vertices.size() -1; i>=0; i--){
            sb.append(vertices.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}