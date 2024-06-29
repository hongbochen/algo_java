package site.laoc.postgraexam.next_higher_temp;

import java.util.Scanner;
import java.util.Stack;

public class NextHigherTemp {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        String str = scanner.nextLine();

        String strs[] = str.split(" ");
        int temperatures[] = new int[strs.length];

        for(int p = 0;p< strs.length;p++){
            temperatures[p] = Integer.parseInt(strs[p]);
        }

        int len = temperatures.length;
        int []answer = new int[len];    //所求结果
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<len; i++) {
            //一直要把小于当前温度的都出栈，因为当前温度就是他们要找的温度
            while(!stack.isEmpty() && temperatures[stack.peek()]<temperatures[i]) {
                int index = stack.pop();
                answer[index] = i - index;
            }
            stack.add(i);
        }

        for(int i = 0;i < answer.length;i++){
            System.out.print(answer[i] + " ");
        }

        System.out.println();
    }
}
