import java.util.*;

class Gem implements Comparable<Gem>{
    int w,v;
    double vw;
    public Gem (int w, int v, double vw){
        this.w = w;
        this.v = v;
        this.vw = vw;
    }
    @Override
    public int compareTo(Gem g){
        return Double.compare(g.vw, this.vw);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Gem> list= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            list.add(new Gem(w,v,(double)v/w));
        }
        Collections.sort(list);
        int currentW = 0;
        double sum = 0;
        for(Gem g : list){
            if(currentW + g.w > m){
                sum += g.vw * (m-currentW);
                break;
            }
            else{
                sum += + g.v;
                currentW += g.w;
            }
        }
        System.out.printf("%.3f", sum);
    }
}