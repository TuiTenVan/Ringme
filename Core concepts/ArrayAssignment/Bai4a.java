import java.util.Scanner;

public class Bai4a {
    static boolean[] check = new boolean[10000001];
    public static void sieve() {
        for(int i = 0; i <= 10000000;++i) {
            check[i] = true;
        }
        check[0] = false;
        check[1] = false;
        for(int i = 2; i * i <= 10000000; ++i) {
            if(check[i]) {
                for(int j = i * i; j <= 10000000; j += i){
                    check[j] = false;
                }
            }
        }
    }
    public static void main(String[] args) {
        sieve();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i]  = sc.nextInt();
        }
        int x = sc.nextInt();
        int min = Integer.MAX_VALUE;
        int index = -1;
        for(int i = 0; i < n; i++){
            if(check[arr[i]]){
                if(min > Math.abs(arr[i] - x)){
                    index = i;
                }
            }
        }
        System.out.println(index);
    }
}