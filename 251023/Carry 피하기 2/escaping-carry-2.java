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
                    int result = isCarry(arr[i], arr[j], arr[k]);
                    mx = Math.max(mx, result);
                }
            }
        }
        System.out.print(mx);
    }
    
    static int isCarry(int a, int b, int c){
        String first = Integer.toString(a);
        String second = Integer.toString(b);
        String third = Integer.toString(c);

        int maxLength = Math.max(first.length(), Math.max(second.length(), third.length()));

        for(int i = 0; i < maxLength; i++){
            int v1 = (i < first.length()) ? first.charAt(first.length() - 1 - i) - '0' : 0;
            int v2 = (i < second.length()) ? second.charAt(second.length() - 1 - i) - '0' : 0;
            int v3 = (i < third.length()) ? third.charAt(third.length() - 1 - i) - '0' : 0;
            
            int sum = v1 + v2 + v3;
            
            if(sum >= 10){
                return -1;
            }
        }
        return a + b + c;
    }
}