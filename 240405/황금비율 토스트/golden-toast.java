import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n,m; //식빵의 개수, 레시피 암호문의 개수
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        char[] str = br.readLine().toCharArray();
        List<Character> list =  new LinkedList<>();

        for (int i = 0; i < str.length; i++) {
            list.add(str[i]);
        }

        ListIterator<Character> iter = list.listIterator(list.size());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String c = st.nextToken();
            if(c.equals("L")){
                if(iter.hasPrevious()){
                    iter.previous();
                }
            }
            else if(c.equals("R")){
                if(iter.hasNext()){
                    iter.next();
                }
            }
            else if(c.equals("P")){
                iter.add(st.nextToken().toCharArray()[0]);
            }
            else{
                if(iter.hasNext()){
                    iter.next();
                    iter.remove();
                }
            }
        }
        iter = list.listIterator();
        while(iter.hasNext()){
            sb.append(iter.next());
        }
        System.out.println(sb);
    }
}