package site.laoc.leetcode;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String szs = scanner.nextLine();

        String tmps[] = szs.split(" ");

        int size = Integer.parseInt(tmps[0]);
        int nums = Integer.parseInt(tmps[1]);

        String qin = scanner.nextLine();


        String tmp = qin;
        for(int j = 0;j < nums;j++){
            StringBuffer stringBuffer = new StringBuffer();
            for(int i = 0;i < tmp.length();i++){
                char tt = tmp.charAt(i);
                if(tt == '0'){
                    tt = '1';
                }else{
                    tt = '0';
                }

                stringBuffer.append(tt);
            }

            tmp = stringBuffer.toString();

            int index = 0;
            for(int m = 0;m < tmp.length();m++){
                char tt = tmp.charAt(m);
                if(tt == '1'){
                    index = m;
                    break;
                }
            }

            tmp = tmp.substring(index,tmp.length());

            if(tmp.equals("")){
                break;
            }
        }

        System.out.println(tmp);
    }
}
