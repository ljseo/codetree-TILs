import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        char[] arr = a.toCharArray();
        boolean flag = false;
        for(int i = 0; i<arr.length; i++){
            if(arr[i] == '0'){
                arr[i] = '1';
                flag = true;
                break;
            }
        }
        if(!flag) arr[arr.length - 1]  = '0';
        String str = "";
        for(char c : arr){
            str += c;
        }
        System.out.print(Integer.valueOf(str,2));
        
    }
}