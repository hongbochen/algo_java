package site.laoc.deke;

import java.util.LinkedList;
import java.util.Scanner;

/*
   游戏规则：输入一个只包含英文字母的字符串，
   字符串中的俩个字母如果相邻且相同，就可以消除。
   在字符串上反复执行消除的动作，
   直到无法继续消除为止，
   此时游戏结束。
   输出最终得到的字符串长度。

   输出：原始字符串str只能包含大小写英文字母，字母的大小写敏感，长度不超过100，
   输出游戏结束后字符串的长度

   备注：输入中包含非大小写英文字母是均为异常输入，直接返回0。

   事例：mMbccbc输出为3
    */
public class Ques_69 {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        int len = line.replaceAll("[A-Z]","")
                .replaceAll("[a-z]","")
                .length();

        if(len > 0){
            System.out.println(0);
            return;
        }

        LinkedList<Character> chars = new LinkedList<>();

        for(Character c : line.toCharArray()){
            chars.add(c);
        }

        int count = 0;

        while(chars.size() != count){
            count = chars.size();

            for(int i = 0;i < chars.size() - 1;i++){

                if(chars.get(i) == chars.get(i+1)){
                    int j = i;
                    for(j = i;j < chars.size()-1;j++){

                        if(chars.get(j) != chars.get(j+1)){
                            break;
                        }
                    }

                    for(int m = i;m <= j;m++){
                        chars.remove(i);
                    }
                }
            }


        }
        System.out.println(chars.size());
    }
}
