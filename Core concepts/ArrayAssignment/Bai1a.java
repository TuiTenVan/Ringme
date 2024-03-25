import java.util.Scanner;

public class Bai1a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        boolean check = true;
        for(int i = 0; i < n; i++) {
            if(arr[i] != arr[n - i - 1]) {
                check = false;
                break;
            }
        }
        if(check){
            System.out.println("True");
        }
        else{
            System.out.println("False");
        }
    }
}
