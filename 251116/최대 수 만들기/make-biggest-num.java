import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, (o1,o2) -> {
            String a = Integer.toString(o1);
            String b = Integer.toString(o2);
            if(a.contains(b) || b.contains(a)){
                String ab = a+b;
                String ba = b+a;
                return ab.compareTo(ba); 
                // if(ab.compareTo(ba) < 0) return o2-o1;
                // else return o1 - o2;
            }
            return a.compareTo(b); 
            // if(a.compareTo(b) < 0) return o1-o2;
            // return o2-o1;
        });
        StringBuilder sb = new StringBuilder();
        for(int i = arr.length-1; i>=0; i--){
            sb.append(arr[i]);
        }
        System.out.print(sb);
        
    }
}