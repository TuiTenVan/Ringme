public class Bai9 {
    public static boolean satisfiesConditions(long n) {
        return checkSTN(n) && check068(n) && checkSum(n);
    }

    public static boolean checkSTN(long n){
        String s = Long.toString(n);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) !=  s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }

    public static boolean check068(long n) {
        while (n > 0) {
            int digit = (int) (n % 10);
            if (digit != 0 && digit != 6 && digit != 8) {
                return false;
            }
            n /= 10;
        }
        return true;
    }

    public static boolean checkSum(Long n){
        String s = Long.toString(n);
        Long sum = 0L;
        for(int i = 0; i < s.length(); i++){
            sum += s.charAt(i) - '0';
        }
        return sum % 10 == 0;
    }

    public static void main(String[] args) {
        for (long i = 1000000; i < 1000000000; i++) {
            if (satisfiesConditions(i)) {
                System.out.print(i + " ");
            }
        }
    }
}
