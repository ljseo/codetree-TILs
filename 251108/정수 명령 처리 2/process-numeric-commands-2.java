import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i<n; i++){
            String order = sc.next();
            if(order.equals("push")){
                queue.add(sc.nextInt());
            }
            if(order.equals("pop")){
                System.out.println(queue.poll());
            }
            if(order.equals("size")){
                System.out.println(queue.size());
            }
            if(order.equals("empty")){
                System.out.println(queue.isEmpty() ? 1 : 0);
            }
            if(order.equals("front")){
                System.out.println(queue.peek());
            }
        }

    }
}