package String;

import java.util.Scanner;
public class Bai3 {
    public static String ChuanHoa(String s){
        StringBuilder sb = new StringBuilder();
        sb.append(Character.toUpperCase(s.charAt(0)));
        for(int i = 1; i < s.length(); i ++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().toLowerCase();
        String[] words = s.split("\\s+");
        String tmp = "";
        for(String word : words){
            tmp += ChuanHoa(word) + " ";
        }
        System.out.println(tmp.substring(0, tmp.length() - 1));
    }
}
