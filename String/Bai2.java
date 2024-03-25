package String;

import java.util.Scanner;

public class Bai2 {
    public static String ChuanHoa(String s){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i ++){
            if(i % 2 == 0){
                sb.append(Character.toUpperCase(s.charAt(i)));
            }
            else{
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        System.out.println(ChuanHoa(s));
    }
}
