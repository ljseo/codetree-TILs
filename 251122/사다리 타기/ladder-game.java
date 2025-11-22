import java.util.*;


class Line{
    int width;
    int height;
    public Line(int width, int height){
        this.width = width;
        this.height = height;
    }
}
public class Main {

    static final int MAX_N = 11;

    static int n,m;
    static ArrayList<Line> lines = new ArrayList<>();
    static ArrayList<Line> selected = new ArrayList<>();
    static int[] targetRes = new int[MAX_N + 1];
    static int[] simulationRes = new int[MAX_N + 1];

    static boolean isFind = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < m; i++){
            int a = sc.nextInt() - 1; // zero-base
            int b = sc.nextInt() - 1;
            lines.add(new Line(a,b));
            selected.add(new Line(a,b));
        }
        simulation(); // 주어진 모든 가로줄을 선택하고 시뮬레이션, 그 결과를 초기값으로 설정 
        for(int i = 0; i < n; i++){
            targetRes[i] = simulationRes[i];
        }

        Collections.sort(lines, (o1, o2) -> {
            return o1.height - o2.height;
        });

        for(int i = 0; i < m; i++){
            if(isFind) break;
            selectLine(0,0,i);
        }

    }

    static void selectLine(int currentIdx, int currentCnt, int targetCnt){
        if(currentCnt == targetCnt){
            if(!isFind) {
                simulation();
                boolean flag = true;
                for(int i = 0; i < n; i++){
                    if(simulationRes[i] != targetRes[i]) {
                        flag = false;
                        break;
                    }
                }
                if(falg) {
                    System.out.println(currentCnt);
                    isFind = true;
                }

            }
            return;
        }

        if(selected.size() == 0){
            selected.add(lines.get(currentIdx));
            selectLine(currentCnt+1, currentIdx+1, targetCnt);
            selected.remove(selected.size()-1);
            selectLine(currentCnt, currentIdx+1, targetCnt);
        }
        else {
            Line previous = selected.get(selected.size()-1);
            Line current = lines.get(currentIdx);
            if(previous.height == current.height && previous.width == (current.width-1)){
                selectLine(currentCnt, currentIdx+1, targetCnt);
            }
            else{
                selected.add(current);
                selectLine(currentCnt+1, currentIdx+1, targetCnt);
                selected.remove(selected.size()-1);
                selectLine(currentCnt, currentIdx+1, targetCnt);
            }
        }

    }

    static void simulation(){
        
        for(int i = 0; i < n; i++){
            simulationRes[i] = i;
        }

        Collections.sort(selected, (o1, o2) -> {
            return o1.height - o2.height;
        });
        // System.out.println(selected.size());
        // for(Line l : selected){
        //     System.out.println(l.width + "  " + l.height);
        // }
        
        for(int i = 0; i < selected.size(); i++){
        
            int start = selected.get(i).width;
            int end = width + 1;

            for(int j = 0; j < n; j++){
                if(simulationRes[j] == start) {
                    simulationRes[j]++;
                }
                else if(simulationRes[j] == end){
                    simulationRes[j]--;
                }
            }
        }
        

    }
}