import java.util.*;
import java.io.*;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        String s = br.readLine();
    
        List<Character> list = new ArrayList<>();
        for(char c : s.toCharArray()){
            list.add(c);
        }
        ListIterator<Character> it = list.listIterator();
        while(it.hasNext()){
            it.next();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
 
            if(command.equals("L")){
                if(it.hasPrevious()) it.previous();
            }
            if(command.equals("R")){
                if(it.hasNext()) it.next();
            }
            if(command.equals("D")){
                if(it.hasNext()){
                    it.next();
                    it.remove();
                }
            }
            if(command.equals("P")){                
                char c = st.nextToken().charAt(0);
                it.add(c);
            }

        }
        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        System.out.println(sb);
    }
}