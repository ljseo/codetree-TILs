import java.util.Scanner;
public class Main {

    static final int MAX_POSITION = 10000;
    static int[] arr = new int[MAX_POSITION+1]; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            int pos = sc.nextInt();
            char c = sc.next().charAt(0);
            if(c == 'G') arr[pos] = 1;
            else arr[pos] = 2;
        }

        int mx = -1;
        int sum =0;
        for(int i = 1; i< MAX_POSITION-k; i++){
            sum = 0;
            for(int j = 0; j<=k; j++){
                sum += arr[i+j];
            }
            mx = Math.max(mx,sum);
        }
        System.out.println(mx);


    }
}