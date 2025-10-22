import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int mx = -1;
        for(int i = 0; i<n; i++){
            for(int j = i+1; j<n; j++){
                for(int k = j+1; k<n; k++){
                    int carry = isCarry(arr[i], arr[j]);
                    if(carry != -1){
                        carry = isCarry(carry, arr[k]);
                        mx = Math.max(mx, carry);
                    }
                }
            }
        }
        System.out.print(mx);
    }
    static int isCarry(int a, int b){
        
        String first = Integer.toString(a);
        String second = Integer.toString(b);

        int length = Math.min(first.length(), second.length());

        for(int i = 0; i<length; i++){
            int v = first.charAt(first.length() - 1 - i) - '0';
            int e = second.charAt(second.length() - 1 - i) - '0';
            if(v + e >= 10){
                return -1;
            }
        }
        return a+b;
    }
}