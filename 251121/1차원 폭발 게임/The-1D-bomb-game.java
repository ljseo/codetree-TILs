import java.util.*;

public class Main {

    static final int MAX_N = 100;
    static int n,m;
    static int[] blocks = new int[MAX_N];
    static int[] nextBlocks = new int[MAX_N];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for(int i = 0; i < n; i++){
            blocks[i] = sc.nextInt();
        }
        simulation();
        System.out.println(n);
        for(int i = 0; i < n; i++){
            System.out.println(blocks[i]);
        }
    }

    static void simulation(){
        while(bomb() != -1){
            downBlocks();
        }
    }

    static void downBlocks(){
        int nextLen = 0;
        for(int i = 0; i < n; i++){
            if(blocks[i] != 0){
                nextBlocks[nextLen++] = blocks[i];
            }
        }
        blocks = nextBlocks;
        n = nextLen;
    }

    static int bomb(){

        boolean flag = false;
        int cnt = 1;
        for(int i = 1; i < n; i++){
            if(blocks[i] != blocks[i-1]){
                if(cnt >= m){
                    flag = true;
                    for(int j = 1; j <= cnt; j++){
                        blocks[i-j] = 0;
                    }
                }
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        
        if(n != 0 && cnt >= m){
            flag = true;
            for(int j = 1; j <= cnt; j++){
                blocks[n-j] = 0;
            }
        }
        return flag ? 1 : -1;
    }

}
