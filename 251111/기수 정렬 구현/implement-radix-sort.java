import java.util.*;

public class Main {
    static final int MAX_VALUE = 100_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        List<Integer>[] lists = new List[10];

        for(int i = 0; i<10; i++){
            lists[i] = new ArrayList<>();
        }

        int len = Integer.toString(MAX_VALUE).length();
        for(int i = 0; i<len; i++){
            for(int j = 0; j<n; j++){
                int idx = Integer.toString(arr[j]).length() - i - 1;
                int val = 0;
                 if(idx < 0) {
                    lists[0].add(arr[j]);
                } else {
                    lists[Integer.toString(arr[j]).charAt(idx) - '0'].add(arr[j]);
                }
            }

            int[] nextArr = new int[n];
            int idx = 0;
            for(int j = 0; j<10; j++){
                for(int a : lists[j]){
                    nextArr[idx++] = a;
                }
                lists[j].clear();
            }
            
            arr = nextArr;
        }
        for(int a : arr){
            System.out.print(a + " ");
        }
        
            


    }
}