import java.util.*;
import java.io.*;

class Data{
    int count;
    int num;
    public Data(int count, int num){
        this.count = count;
        this.num = num;
    }
}

public class Main {

    static final int MAX_N = 100000;

    static Data[] datas = new Data[MAX_N+1];
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            datas[i] = new Data(x,y);
        }

        int left = 0;
        int right = n-1;
        int mn = Integer.MAX_VALUE;
        while(left <= right){
            while(left < n && datas[left].count == 0){
                left++;
            }
            if(left >= n) break;
            while(right >= 0 && datas[right].count == 0){
                right--;
            }
            if(right < 0) break;

            datas[left].count--;
            datas[right].count--;
            int sum = datas[left].num + datas[right].num;
            mn = Math.min(mn, sum);
        }
        System.out.print(mn);
    }
}