import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        int length = input.length();
        char [] arr = input.toCharArray();
        int res = 0;
        for(int i = 0; i<length-1; i++){
            for(int j = i+2; j<length-1; j++){
                if(arr[i] == '(' && arr[i+1] == '(' 
                && arr[j] == ')' && arr[j+1] == ')'){
                    res++;
                }
            }
        }
        System.out.print(res);
    }
}