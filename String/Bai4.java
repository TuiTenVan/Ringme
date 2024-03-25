package String;

import java.util.Scanner;

public class Bai4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] words = s.split("\\s+");
        String tmp = words[0];
        int ans = 0;
        for(int i = 1; i < words.length; i++){
            if(words[i].length() > tmp.length()){
                ans = i;
                tmp = words[i];
            }
        }
        System.out.println("Từ có kí tự dài nhất: " + tmp);
        System.out.println("Xuất hiện ở vị trí: " + (ans + 1));
    }
}
