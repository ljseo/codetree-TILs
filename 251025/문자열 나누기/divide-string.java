import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String [] arr = new String[n];


        int cnt = 0;
        for(int i = 0; i<n; i++){
            arr[i] = st.nextToken();
            for(char c : arr[i].toCharArray()){
                System.out.print(c);
                cnt++;
                if(cnt % 5 == 0) System.out.print("\n");             
            }
        }





        
    }
}