package String;

import java.util.Scanner;
public class Bai5 {
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
        StringBuilder sb = new StringBuilder();
        sb.append(ChuanHoa(words[words.length - 1]) + " ");
        for(int i = 0; i < words.length - 1; i++){
            sb.append(ChuanHoa(words[i]) + " ");
        }
        System.out.println(sb);
    }
}
