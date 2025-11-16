import java.util.*;
import java.io.*;
class Meeting implements Comparable<Meeting>{
    int start;
    int end;
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
    @Override
    public int compareTo(Meeting m){
        return end - m.end;
    }
}
public class Main {

    static final int MAX_N = 100000;
    
    static int n;
    static Meeting[] meetings = new Meeting[MAX_N];

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meeting(start, end);
        }
        Arrays.sort(meetings,0,n);

        int currentTime = 0;
        int cancleCnt = 0;
        for(int i = 0; i < n; i++){
            int start = meetings[i].start;
            int end = meetings[i].end;
            if(currentTime <= start){
                currentTime = end;
            }
            else{
                cancleCnt++;
            }
        }
        System.out.println(cancleCnt);
    }
}