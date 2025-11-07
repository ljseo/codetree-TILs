import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i<n; i++){
            String order = sc.next();
            if(order.equals("push")){
                int num = sc.next();
                stack.push(num);
            }
            if(order.equals("pop")){
                System.out.println(stack.pop());
            }
            if(order.equals("size")){
                System.out.println(stack.size());
            }
            if(order.equals("top")){
                System.out.println(stack.peek());
            }
        }
    }
}