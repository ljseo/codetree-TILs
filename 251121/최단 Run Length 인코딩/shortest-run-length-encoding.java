import java.util.Scanner;

public class Main {

    static String A;

    static void shift(){
        char[] arr = A.toCharArray();
        char temp = arr[arr.length-1];
        for(int i = arr.length-1; i>0; i--){
            arr[i] = arr[i-1];
        }
        arr[0] = temp;
        A = String.valueOf(arr);
    }

    static int getRunLengthEncodingLen(){
        char[] arr = A.toCharArray();
        StringBuilder sb = new StringBuilder();
        int cnt = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] != arr[i-1]){
                sb.append(arr[i-1]).append(cnt);
                cnt = 1;
            }
            else{
                cnt++;
            }
        }
        sb.append(arr[arr.length-1]).append(cnt);
        return sb.length();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        int len  = A.length();
        int mn = getRunLengthEncodingLen();
        for(int i = 0; i < len; i++){
            shift();
            mn = Math.min(mn, getRunLengthEncodingLen());
        }
        System.out.println(mn);

    }
}