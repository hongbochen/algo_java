package site.laoc.leetcode;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        String str1 = scanner.nextLine();
        String str2 = scanner.nextLine();

        // 00010101000
        // 11010010101

        StringBuffer sb = new StringBuffer();
        int size = 0;
        for(int i = 0;i < str1.length();i++){
            char tmp = str1.charAt(i);

            for(int m = 0;m < str2.length();m++){
                if(str2.charAt(m) == str1.charAt(i)){
                    boolean isrun = true;
                    int p = 0;
                    while(isrun){
                        if((i+p < str1.length()) && (m+p < str2.length()) && (str1.charAt(i+p) == str2.charAt(m+p))){
                            p++;
                        }else{
                            isrun = false;
                        }
                    }

                    if(p > size){
                        size = p;
                    }

                }
            }
        }

        System.out.println(size+2);
    }
}
