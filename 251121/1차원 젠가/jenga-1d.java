import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] blocks = new int[n];
        for (int i = 0; i < n; i++) {
            blocks[i] = sc.nextInt();
        }
        int s1 = sc.nextInt() - 1;
        int e1 = sc.nextInt() - 1;
        int s2 = sc.nextInt() - 1;
        int e2 = sc.nextInt() - 1;
        int[] temp = new int[n];
        int tempIdx = 0;
        for(int i = 0; i < n; i++){
            if(i >= s1 && i <= e1) continue;
            temp[tempIdx++] = blocks[i];
        }
        blocks = temp;
        int len = tempIdx;
        tempIdx = 0;
        for(int i = 0; i < len; i++){
            if(i >= s2 && i <= e2) continue;
            temp[tempIdx++] = blocks[i];
        }
        
        System.out.println(tempIdx);
        for(int i = 0; i < tempIdx; i++){
            System.out.println(temp[i]);
        }
    }
}