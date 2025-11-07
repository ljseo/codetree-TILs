import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        // Please write your code here.
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i<str.length(); i++){
            char c = str.charAt(i);
            if(c == '('){
                stack.push(1);
            }
            if(c == ')'){
                if(stack.isEmpty()) {
                    System.out.println("No");
                    return;
                }
                stack.pop();
            }
        }
        if(!stack.isEmpty()) System.out.println("No");
        else System.out.println("Yes");
    }
}