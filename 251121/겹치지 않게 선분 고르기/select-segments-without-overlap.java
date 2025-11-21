import java.util.*;

class Line{
    int start;
    int end;
    public Line(int start, int end){
        this.start = start;
        this.end = end;
    }
}

public class Main {

    static int n;
    static int mx = 0;
    static Line[] lines;
    static ArrayList<Line> selected = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        lines = new Line[n];
        for(int i = 0; i < n; i++){
            int start = sc.nextInt();
            int end = sc.nextInt();
            lines[i] = new Line(start, end);
        }

        selectLine(0);
        System.out.println(mx);
    }

    static void selectLine(int idx){
        if(idx == n){
            if(!isOverlap()){
                mx = Math.max(mx, selected.size());
            }
            return;
        }
        
        selectLine(idx+1);
        selected.add(lines[idx]);
        selectLine(idx+1);
        selected.remove(selected.size()-1);
    }

    static boolean isOverlap(){

        int len = selected.size();
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                Line line1 = selected.get(i);
                Line line2 = selected.get(j);
                if((line2.start <= line1.end && line1.start <= line2.start) 
                || (line2.end <= line1.end && line1.start <= line2.end)){
                    return true;
                }
            }
        }
        return false;
    }
}