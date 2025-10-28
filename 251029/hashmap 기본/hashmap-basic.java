import java.io.*;
import java.util.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());

        // Please write your code here.
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String oper = st.nextToken();
            int key = Integer.parseInt(st.nextToken());
            if(oper.equals("add")){
                int value = Integer.parseInt(st.nextToken());
                map.put(key, value);
            }
            else if(oper.equals("find")){
                if(!map.containsKey(key))System.out.println("None");
                else System.out.println(map.get(key));
            }
            else{
                map.remove(key);
            }
        }
    }
}