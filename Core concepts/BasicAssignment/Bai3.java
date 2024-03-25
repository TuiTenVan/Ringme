import java.util.Scanner;

public class Bai3 {
    public static long gcd(long a, long b){
        while(b > 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    public static long lcm(long a, long b){
        return a / gcd(a, b) * b;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long a = sc.nextLong();
        Long b = sc.nextLong();
        System.out.println(gcd(a, b) + " " + lcm(a, b));
    }
}
