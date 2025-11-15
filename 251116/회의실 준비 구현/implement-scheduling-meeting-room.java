import java.util.*;

class Meeting{
    int start;
    int end; 
    public Meeting(int start, int end){
        this.start = start;
        this.end = end;
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Meeting[] meetings = new Meeting[n];
        for (int i = 0; i < n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            meetings[i] = new Meeting(s,e);
        }
        Arrays.sort(meetings, (o1,o2) -> o1.end - o2.end);

        int cnt = 1;
        int currentTime = meetings[0].end;
        for(int i = 1; i<n; i++){
            if(currentTime <= meetings[i].start) {
                cnt++;
                currentTime = meetings[i].end;
            }
        }
        System.out.println(cnt);
        
    }
}