import java.util.*;
import java.io.*;

public class Main {


    static class Node {
        int index;
        int weight;
        public Node(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }

    static class Element implements Comparable<Element> {
        int weight;
        int index;
        public Element(int weight, int index){
            this.weight = weight;
            this.index = index;
        }
        @Override
        public int compareTo(Element e){
            return this.weight - e.weight;
        }
    }


    static final int MAX_N = 20000;
    static int[] dist = new int[MAX_N+1];
    static PriorityQueue<Element> pq = new PriorityQueue<>();
    static ArrayList<Node>[] list = new ArrayList[MAX_N+1];
    static int n,m,k;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(br.readLine());

        for(int i = 1; i<=n; i++){
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Node(v,w));
            list[v].add(new Node(u,w));
        }

        Arrays.fill(dist, (int)1e9);
        dist[k] = 0;
        pq.add(new Element(0, k));

        while(!pq.isEmpty()){
            int w = pq.peek().weight;
            int idx = pq.peek().index;
            pq.poll();

            if(dist[idx] != w) continue;

            for(int i = 0; i<list[idx].size(); i++){
                int index = list[idx].get(i).index;
                int weight = list[idx].get(i).weight;

                if(dist[idx] + weight < dist[index]){
                    dist[index] = dist[idx] + weight;
                    pq.add(new Element(dist[index], index));
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<=n; i++){
            sb.append(dist[i] == (int)1e9 ? -1 : dist[i]).append("\n");
        }
        System.out.println(sb);

    }
}