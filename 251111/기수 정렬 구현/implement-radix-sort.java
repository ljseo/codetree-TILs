import java.util.*;

public class Main {
    static final int MAX_VALUE = 100_000;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        List<Integer>[] lists = new ArrayList[10];
        
        // ✅ 올바른 초기화
        for(int i = 0; i < 10; i++){
            lists[i] = new ArrayList<>();
        }

        int len = Integer.toString(MAX_VALUE).length();
        for(int i = 0; i < len; i++){
            // 각 숫자를 해당 자릿수에 따라 버킷에 분배
            for(int j = 0; j < n; j++){
                int idx = Integer.toString(arr[j]).length() - i - 1;
                if(idx < 0) {
                    lists[0].add(arr[j]);  // ✅ 자릿수 없으면 0으로 간주
                } else {
                    lists[Integer.toString(arr[j]).charAt(idx) - '0'].add(arr[j]);
                }
            }

            // ✅ 버킷에서 순서대로 꺼내기
            int[] nextArr = new int[n];
            int idx = 0;
            for(int j = 0; j < 10; j++){
                for(int a : lists[j]){
                    nextArr[idx++] = a;
                }
                lists[j].clear();  // ✅ 다음 단계를 위해 비우기
            }
            arr = nextArr;
        }
        
        for(int a : arr){
            System.out.print(a + " ");
        }
    }
}