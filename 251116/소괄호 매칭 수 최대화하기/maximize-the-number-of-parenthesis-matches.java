import java.util.*;
import java.io.*;

class Element implements Comparable<Element>{
    String str;
    int openCnt;
    int closeCnt;
    public Element (String str){
        this.str = str;
        for(char c : str.toCharArray()){
            if(c == '(') openCnt++;
            else closeCnt++;
        }
    }
    @Override
    public int compareTo(Element e){
        if(closeCnt == e.closeCnt) return e.openCnt - openCnt;
        return closeCnt - e.closeCnt; 
    }
}


public class Main {

    static final int MAX_N = 100000;
    static Element[] elements = new Element[MAX_N];
    static int n;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        for(int i = 0; i<n; i++){
            elements[i] = new Element(br.readLine());
        }
        Arrays.sort(elements,0,n);

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<n; i++){
            // System.out.println(elements[i].str);
            sb.append(elements[i].str);
        }
        // System.out.println(sb);
        String sumStr = sb.toString();
        int closeCnt = 0;
        for(char c : sumStr.toCharArray()){
            if(c == ')') closeCnt++;
        }
        int total = 0;
        for(char c : sumStr.toCharArray()){
            if(c == ')') closeCnt--;
            else total += closeCnt;
        }
        System.out.println(total);
    }
}