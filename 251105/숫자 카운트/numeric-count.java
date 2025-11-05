import java.util.Scanner;
public class Main {
    static final int MAX_NUM = 1000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] num = new int[n];
        int[] count1 = new int[n];
        int[] count2 = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            count1[i] = sc.nextInt();
            count2[i] = sc.nextInt();
        }

        int[] cnt = new int[MAX_NUM];


        for(int i = 0; i<n; i++){
            int first = (num[i] / 100) % 10;
            int second = (num[i] / 10) % 10;
            int third = num[i] % 10;

            for(int j = 1; j<10; j++){
                for(int k = 1; k<10; k++){
                    for(int l = 1; l<10; l++){
                        int cnt1 = 0;
                        int cnt2 = 0;
                        if(j == k || k == l || l == j) continue;
                        if(j == first) cnt1++;
                        if(k == second) cnt1++;
                        if(l == third) cnt1++;
                        if(j == second) cnt2++;
                        if(j == third) cnt2++;
                        if(k == first) cnt2++;
                        if(k == third) cnt2++;
                        if(l == first) cnt2++;
                        if(l == second) cnt2++;
                        if(cnt1 == count1[i] && cnt2 == count2[i]){
                            cnt[j*100 + k*10+l]++;
                        }
                    }
                }
            }
        }
        
        int res = 0;
        for(int a : cnt){
            if(a ==n) {
                res++;
            }
        }
        System.out.println(res);
    }
}