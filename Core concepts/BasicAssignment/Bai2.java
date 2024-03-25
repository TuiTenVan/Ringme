import java.util.Scanner;

public class Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        int count = 0;
        for(int i = 1; i <= Math.sqrt(n); i++){
            if(n % i == 0){
                if(Math.pow(n / i, 2) != n){
                    System.out.println(i + " " + n / i);
                    count += 2;
                }
                else{
                    System.out.println(i);
                    count += 1;
                }
            }
        }
        System.out.println(count);
    }
}
