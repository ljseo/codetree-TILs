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
        if(b == black.b) return a - black.a;
        return black.b - b; 
    }
}

public class Main {
    
    static final int MAX_C = 100000;
    static final int MAX_N = 100000;

    static int c,n;
    static Integer[] reds = new Integer[MAX_C];
    static Black[] blacks = new Black[MAX_N];

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
        Arrays.sort(reds,0,c,(o1, o2) -> o2-o1);
        Arrays.sort(blacks,0,n);
        
        int redIdx = 0;
        int blackIdx = 0;
        int cnt = 0;
        while(redIdx < c && blackIdx < n){
            int redNum = reds[redIdx];
            Black blackNum = blacks[blackIdx];
            int a = blackNum.a;
            int b = blackNum.b;
            if(a <= redNum && redNum <= b){
                cnt++;
                redIdx++;
                blackIdx++;
            }
            else if(redNum < a) {
                blackIdx++;
            }
            else if(b < redNum) {
                redIdx++;
            }
        }
        System.out.print(cnt);
    }
}