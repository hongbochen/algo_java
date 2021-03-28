package site.laoc.leetcode.letter_combinations_of_a_phone_number;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombOfAPhoneNumber {

    Map<Character,String> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0)
            return list;

        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");

        recvComb(digits,0);

        return list;
    }

    private void recvComb(String digits, int index){
        if(index >= digits.length()){
            list.add(sb.toString());
            return;
        }

        char c = digits.charAt(index);

        String s = map.get(c);

        for(int i = 0;i < s.length();i++){
            sb.append(s.charAt(i));
            recvComb(digits,index+1);
            sb.setLength(sb.length()-1);
        }
    }

    public static void main(String [] args){
        LetterCombOfAPhoneNumber letterCombOfAPhoneNumber = new LetterCombOfAPhoneNumber();
        List<String> list = letterCombOfAPhoneNumber.letterCombinations("234");

        for(int i = 0;i < list.size();i++){
            System.out.println(list.get(i));
        }
    }
}
