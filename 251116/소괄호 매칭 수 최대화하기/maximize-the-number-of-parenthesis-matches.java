import java.util.*;
import java.io.*;

class Element implements Comparable<Element>{
    int open;
    int close;
    public Element (int open, int close){
        this.open = open;
        this.close = close;
    }
    @Override
    public int compareTo(Element e){
        return e.open * this.close - this.open * e.close;
    }
}


public class Main {

    static final int MAX_N = 100000;
    static Element[] elements = new Element[MAX_N];
    static int n;
    static long ans;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            String s = br.readLine();
            int open = 0;
            int close = 0;
            for(int j = 0; j < s.length(); j++){
                if(s.charAt(j) == ')') {
                    close++;
                    ans+=open;
                }
                else {
                    open++;
                }
            }
            elements[i] = new Element(open,close);
        }
        Arrays.sort(elements,0,n);

        int openSum = 0;
        for(int i = 0; i < n; i++){
            int open = elements[i].open;
            int close = elements[i].close;

            ans += (long) openSum * close;
            openSum += open;
        }
        System.out.println(ans);

    }
}