import java.util.*;

public class Main {

    static int n,k;
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        k = sc.nextInt();
        n = sc.nextInt();
        chooseNum(1);
    }
    static void chooseNum(int cnt){
        if(cnt == n+1){
            for(int a : list){
                System.out.print(a + " ");
            }
            System.out.println();
            return;
        }
        for(int i = 1; i <= k; i++){
            list.add(i);
            chooseNum(cnt+1);
            list.remove(list.size() - 1);
        }
    }
}