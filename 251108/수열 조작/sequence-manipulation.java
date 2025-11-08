import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> dq = new LinkedList<>();
        
        for(int i = 1; i<=n; i++){
            dq.add(i);
        }
        while(dq.size() != 1){
            dq.poll();
            dq.add(dq.poll());
        }
        System.out.println(dq.poll());

    }
}