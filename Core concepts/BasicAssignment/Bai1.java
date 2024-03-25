import java.util.*;

public class Bai1{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long n = sc.nextLong();
        Long sum = 0L;
        if(n % 2 == 0){
            sum = (n / 2) * (n + 2) / 2;
        }
        else{ 
            sum = (n + 1) / 2 * (n + 1) / 2;
        }
        System.out.println(sum);
        Double sumDouble = 0.0;
        for(int i = 1; i <= n; i++){
            sumDouble += (double) 1 / i;
        }
        System.out.printf("%.4f",sumDouble);
    }
}