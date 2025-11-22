import java.util.*;


class Line implements Comparable<Line> {
    int width;
    int height;
    public Line(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public int compareTo(Line l){
        if(this.height == l.height) return this.width - l.width;
        return this.height - l.height;
    }
}
public class Main {

    static final int MAX_N = 11;

    static int n,m;
    static int ans = Integer.MAX_VALUE;

    static ArrayList<Line> lines = new ArrayList<>();
    static ArrayList<Line> selected = new ArrayList<>();

    static int[] targetRes = new int[MAX_N + 1];
    static int[] simulationRes = new int[MAX_N + 1];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1; // zero-base
            int b = sc.nextInt() - 1;
            lines.add(new Line(a,b));
        }
        Collections.sort(lines);
        for(Line l : lines){
            selected.add(l);
        }
        simulation(); // 주어진 모든 가로줄을 선택하고 시뮬레이션, 그 결과를 초기값으로 설정 
        for(int i = 0; i < n; i++){
            targetRes[i] = simulationRes[i];
        }
        selected.clear();   
        selectLine(0);
        System.out.println(ans);

    }
    static void simulation(){
        
        for(int i = 0; i < n; i++){
            simulationRes[i] = i;
        }
        
        for(int i = 0; i < selected.size(); i++){
            int start = selected.get(i).width;
            int end = selected.get(i).width + 1;
            int temp = simulationRes[start];
            simulationRes[start] = simulationRes[end];
            simulationRes[end] = temp;
        }
    }

    static void selectLine(int currentCnt){

        if(currentCnt == m){
            simulation();
            boolean flag = true;
            for(int i = 0; i < n; i++){
                if(simulationRes[i] != targetRes[i]) {
                    flag = false;
                    break;
                }
            }
            if(flag) {
                ans = Math.min(ans, selected.size());
            }
            return;
        }

        selected.add(lines.get(currentCnt));
        selectLine(currentCnt+1);
        selected.remove(selected.size()-1);
        selectLine(currentCnt+1);

    }
}