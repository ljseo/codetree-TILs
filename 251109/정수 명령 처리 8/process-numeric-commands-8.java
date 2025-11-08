import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            String command = sc.next();
            if(command.equals("push_front")){
                list.addFirst(sc.nextInt());
            }
            if(command.equals("push_back")){
                list.addLast(sc.nextInt());
            }
            if(command.equals("pop_front")){
                System.out.println(list.pollFirst());
            }
            if(command.equals("pop_back")){
                System.out.println(list.pollLast());
            }
            if(command.equals("size")){
                System.out.println(list.size());
            }
            if(command.equals("front")){
                System.out.println(list.peekFirst());
            }
            if(command.equals("back")){
                System.out.println(list.peekLast());
            }
            if(command.equals("empty")){
                System.out.println(list.isEmpty() ? 1: 0);
            }
        }
    }
}