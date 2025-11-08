import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i<n; i++){
            String order = sc.next();
            if(order.equals("push_front")){
                deque.addFirst(sc.nextInt());
            }
            if(order.equals("push_back")){
                deque.addLast(sc.nextInt());
            }
            if(order.equals("pop_front")){
                System.out.println(deque.pollFirst());
            }
            if(order.equals("pop_back")){
                System.out.println(deque.pollLast());
            }
            if(order.equals("size")){
                System.out.println(deque.size());
            }
            if(order.equals("empty")){
                System.out.println(deque.isEmpty()? 1:0);
            }
            if(order.equals("front")){
                System.out.println(deque.peekFirst());
            }
            if(order.equals("back")){
                System.out.println(deque.peekLast());
            }
        }

    }
}