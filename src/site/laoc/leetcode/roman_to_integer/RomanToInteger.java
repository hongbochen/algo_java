package site.laoc.leetcode.roman_to_integer;

import java.util.ArrayList;
import java.util.List;

public class RomanToInteger {

    public int romanToInt(String s) {
        List<Character> list = getList();
        List<Integer> inList = getIntList();

        int sum = 0;

        int i = 0;
        while(i < s.length()){
            int t1 = i + 1;
            char c = s.charAt(i);

            if(t1 < s.length()){
                char c1 = s.charAt(t1);

                int m = list.indexOf(c);
                int n = list.indexOf(c1);
                if(m < n){
                    sum = sum + inList.get(n) - inList.get(m);
                    i += 2;
                }else{
                    sum = sum + inList.get(m);
                    i += 1;
                }
            }else{
                sum = sum + inList.get(list.indexOf(c));
                i += 1;
            }
        }

        return sum;
    }

    private ArrayList<Character> getList(){
        ArrayList<Character> list = new ArrayList<>();
        list.add('I');
        list.add('V');
        list.add('X');
        list.add('L');
        list.add('C');
        list.add('D');
        list.add('M');

        return list;
    }

    private ArrayList<Integer> getIntList(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(5);
        list.add(10);
        list.add(50);
        list.add(100);
        list.add(500);
        list.add(1000);

        return list;
    }

    public static void main(String [] args){
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("LVIII"));
    }
}
