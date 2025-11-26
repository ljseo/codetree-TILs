import java.util.*;

public class Main {
    static String expr;
    static int[] values = new int[6]; // a~f에 대응하는 값
    static int maxResult = Integer.MIN_VALUE;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        expr = sc.nextLine();
        
        // 모든 조합 시도 (백트래킹)
        solve(0);
        
        System.out.println(maxResult);
    }
    
    static void solve(int idx) {
        if (idx == 6) {
            // 모든 알파벳에 값 할당 완료 → 식 계산
            int result = calculate();
            maxResult = Math.max(maxResult, result);
            return;
        }
        
        // 현재 알파벳에 1~4 할당 시도
        for (int v = 1; v <= 4; v++) {
            values[idx] = v;
            solve(idx + 1);
        }
    }
    
    static int calculate() {
        int result = getValue(expr.charAt(0));
        
        for (int i = 1; i < expr.length(); i += 2) {
            char op = expr.charAt(i);
            int operand = getValue(expr.charAt(i + 1));
            
            switch (op) {
                case '+': result += operand; break;
                case '-': result -= operand; break;
                case '*': result *= operand; break;
            }
        }
        
        return result;
    }
    
    static int getValue(char c) {
        return values[c - 'a'];
    }
}