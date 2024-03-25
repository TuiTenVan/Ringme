

public class Bai8b {
    public static boolean CheckSTN(int n){
        String s = Integer.toString(n);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) !=  s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
    public static boolean CheckSum(int n){
        String s = Integer.toString(n);
        Long sum = 0L;
        for(int i = 0; i < s.length(); i++){
            sum += s.charAt(i) - '0';
        }
        return sum % 10 == 0;
    }
    public static void main(String[] args) {
        System.out.println();
        for(int i = 100000; i < 1000000; i++) {
            if(CheckSTN(i) && CheckSum(i)){
                System.out.print(i + " ");
            }
        }
    }
}

