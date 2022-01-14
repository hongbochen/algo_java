package site.laoc.leetcode.longest_valid_parentheses;

import java.util.Stack;


public class LongestValidParentheses {

    /**
     * 定义一个start变量记录合法括号串的起始位置，遍历字符串，如果遇到左括号，则下标压入栈；如果遇到右括号，如果栈为空，则将下一个
     * 坐标位置记录到start，如果栈不为空，则将栈顶元素取出，此时如果栈为空，则更新结果和i - start + 1的最大值；如果栈不为空，
     * 则更新结果和i - stack.peek()中的较大值。
     * @param s
     * @return
     */
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();

        int res = 0;
        int start = 0;

        for(int i = 0; i < s.length();i++){
            char c = s.charAt(i);

            if(c == '('){
                stack.push(i);
            }else{
                if(stack.size() == 0){
                    start = i + 1;
                }else{
                    stack.pop();

                    res = stack.size() == 0 ? Math.max(res,i-start + 1) : Math.max(res,i-stack.peek());
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        LongestValidParentheses longestValidParentheses = new LongestValidParentheses();

        String s = "()(()";

        int size = longestValidParentheses.longestValidParentheses(s);

        System.out.println(size);
    }
}
