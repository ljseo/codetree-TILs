import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i<n; i++){
            String commend = sc.next();
            if(commend.equals("push_back")){
                list.add(sc.nextInt());
            }
            if(commend.equals("pop_back")){
                list.remove(list.size()-1);
            }
            if(commend.equals("size")){
                System.out.println(list.size());
            }
            if(commend.equals("get")){
                System.out.println(list.get(sc.nextInt()-1));
            }
        }
    }
}