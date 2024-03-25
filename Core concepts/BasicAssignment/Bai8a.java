
public class Bai8a {
    public static boolean CheckSTN(int n){
        String s = Integer.toString(n);
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) !=  s.charAt(s.length() - i - 1)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        for(int i = 100000; i < 1000000; i++) {
            if(CheckSTN(i)){
                System.out.print(i + " ");
            }
        }
    }
}

