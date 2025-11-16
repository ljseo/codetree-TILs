import java.util.*;
import java.io.*;

class Black implements Comparable<Black>{
    int a;
    int b;
    public Black(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Black black){
        return a - black.a; 
    }
}
class Element implements Comparable<Element>{
    int a;
    int b;
    public Element(int a, int b){
        this.a = a;
        this.b = b;
    }
    @Override
    public int compareTo(Element e){
        return b - e.b; 
    }
}

public class Main {
    
    static final int MAX_C = 100000;
    static final int MAX_N = 100000;

    static int c,n;
    static Integer[] reds = new Integer[MAX_C];
    static Black[] blacks = new Black[MAX_N];
    static PriorityQueue<Element> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        for(int i = 0; i<c; i++){
            reds[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            blacks[i] = new Black(a,b);
        }
        Arrays.sort(reds,0,c,(o1, o2) -> o1-o2);
        Arrays.sort(blacks,0,n);
        
        int redIdx = 0;
        int blackIdx = 0;
        int cnt = 0;
        while(redIdx < c && blackIdx < n){
            int redNum = reds[redIdx++];
            while(blackIdx < n && blacks[blackIdx].a <= redNum){
                pq.add(new Element(blacks[blackIdx].a, blacks[blackIdx].b));
                blackIdx++;
            }

            while(!pq.isEmpty() && pq.peek().b < redNum){
                pq.poll();
            }
            if(!pq.isEmpty() && pq.peek().b >= redNum){
                cnt++;
                pq.poll();
            }

        }
        System.out.print(cnt);
    }
}