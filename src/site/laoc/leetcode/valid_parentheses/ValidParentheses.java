package site.laoc.leetcode.valid_parentheses;

import java.util.Stack;

// 使用栈解决
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(int i = 0;i < s.length();i++){
            char c = s.charAt(i);

            if(c == '(' || c == '{' || c == '['){
                stack.push(c);
            }else{

                if(stack.empty()){
                    return false;
                }

                char t = stack.pop();

                if((t == '(' && c != ')')
                    || (t == '[' && c != ']')
                    || (t == '{' && c != '}')){
                    return false;
                }
            }
        }

        if(!stack.empty()){
            return false;
        }

        return true;
    }

    public static void main(String [] args){
        String s = "{[]}";

        ValidParentheses validParentheses = new ValidParentheses();
        System.out.println(validParentheses.isValid(s));
    }
}
