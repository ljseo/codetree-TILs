import java.util.Scanner;
public class Main {
    static int n,m;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }
        int[] dr = new int[]{-1,-1,0,1,1,1,0,-1};
        int[] dc = new int[]{0,1,1,1,0,-1,-1,-1};
        int res = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr[i].charAt(j) == 'L'){
                    for(int k = 0; k<8; k++){
                        if(inRange(i+dr[k], j+dc[k]) && arr[i+dr[k]].charAt(j+dc[k]) == 'E' 
                        && inRange(i+dr[k] * 2, j + dc[k] * 2)
                        && arr[i+dr[k]*2].charAt(j+dc[k] * 2) == 'E'){
                            res++;
                        }
                    }
                }
            }
        }
        System.out.print(res);
    }
    static boolean inRange(int r, int c){
        return 0<=r && r<n && 0<=c && c<m;
    }
}