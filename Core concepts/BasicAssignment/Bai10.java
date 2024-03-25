public class Bai10 {

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


    public static boolean allDigitsPrime(int n) {
        while (n > 0) {
            int digit = n % 10;
            if (!isPrime(digit)) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static int reverseNumber(int n) {
        int reversed = 0;
        while (n > 0) {
            int digit = n % 10;
            reversed = reversed * 10 + digit;
            n /= 10;
        }
        return reversed;
    }

    public static void main(String[] args) {
        for (int i = 1000000; i < 10000000; i++) {
            if (isPrime(i) && allDigitsPrime(i) && isPrime(reverseNumber(i))) {
                System.out.println(i);
            }
        }
    }
}
