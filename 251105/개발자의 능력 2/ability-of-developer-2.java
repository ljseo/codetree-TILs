import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int [] ability = new int[6];
        int total = 0;
        for(int i = 0; i<6;i++){
            ability[i] = sc.nextInt();
            total += ability[i];
        }
        int mn = 3000000;
        for(int i = 0; i<6; i++){
            for(int j = 0; j<6; j++){
                for(int k = 0; k<6; k++){
                    for(int l = 0; l<6; l++){
                        if(i == j || i == k || i == l || j == k || j == l || k == l) continue;
                        int first = ability[i] + ability[j];
                        int second = ability[k] + ability[l];
                        int third = total - first - second;
                        mn = Math.min(mn, Math.max(first, Math.max(second, third)) - Math.min(first, Math.min(second, third)));
                    }
                }
            }
        }
        System.out.print(mn);
    }
}