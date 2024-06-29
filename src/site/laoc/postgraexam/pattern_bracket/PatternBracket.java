package site.laoc.postgraexam.pattern_bracket;

import java.util.LinkedList;
import java.util.Scanner;

public class PatternBracket {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());

        for(int p = 0;p < m;p++){
            String s = scanner.nextLine();

            int n = s.length();
            LinkedList<Integer> leftSta = new LinkedList<>();
            LinkedList<Integer> starSta = new LinkedList<>();

            boolean a = true;
            for (int i=0; i<n; i++) {
                char ch = s.charAt(i);
                if (ch == '(') {
                    leftSta.push(i);
                } else if (ch == '*') {
                    starSta.push(i);
                } else {
                    if (!leftSta.isEmpty()) {
                        leftSta.pop();
                    } else if (!starSta.isEmpty()) {
                        starSta.pop();
                    } else {
                        a = false;
                        break;
                    }
                }
            }
            while (!leftSta.isEmpty()) {
                if (starSta.isEmpty()) {
                    a =  false;
                    break;
                }
                // 星号的位置小于左括号的位置
                if (starSta.pop() < leftSta.pop()) {
                    a = false;
                    break;
                }
            }

            System.out.println(a);
        }
    }
}
