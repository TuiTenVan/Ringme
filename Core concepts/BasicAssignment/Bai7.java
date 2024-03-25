public class Bai7 {

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static boolean allOddDigits(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (digit % 2 == 0) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static void main(String[] args) {
        for (int i = 100000; i < 1000000; i++) {
            if (isPrime(i) && allOddDigits(i)) {
                System.out.println(i);
            }
        }
    }
}
