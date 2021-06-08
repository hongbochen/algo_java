package site.laoc.leetcode.generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();

        generate(list,"",0,0,n);

        return list;
    }

    private void generate(List<String> list, String tmp, int left,int right,int n){
        if(tmp.length() == 2 * n){
            list.add(tmp);
            return;
        }

        if(left < n){
            generate(list,tmp + "(",left+1,right,n);
        }

        if(right < left){
            generate(list,tmp + ")", left, right+1,n);
        }
    }

    public static void main(String [] args){
        GenerateParentheses generateParentheses = new GenerateParentheses();

        List<String> list = generateParentheses.generateParenthesis(3);

        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
