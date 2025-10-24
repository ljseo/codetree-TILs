import java.util.Scanner;
public class Main {
    
    static final int MAX_N = 100;
    static char[] arr = new char[MAX_N + 1];
    static int n;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int position = sc.nextInt();
            char ch = sc.next().charAt(0);
            arr[position] = ch;
        }
        int mx = -1;

        for(int i = 0; i<=MAX_N; i++){
            if(arr[i] != 0){
                for(int j = i; j<=MAX_N; j++){
                    if(arr[j] != 0){
                        int cntG = 0;
                        int cntH = 0;
                        for(int k = i; k<=j; k++){
                            if(arr[k] == 'G') cntG++;
                            if(arr[k] == 'H') cntH++;
                        }
                        if(cntG == cntH) {
                            mx = Math.max(mx, j-i);
                        }
                    }
                }

                int cntSeq = 0;
                for(int j = i+1; j<=MAX_N; j++){
                    if(arr[j] != 0 && arr[j] == arr[i]) cntSeq++;
                    else break;
                }
                mx = Math.max(mx, cntSeq);
            }
        }
        System.out.print(mx);

    }
}