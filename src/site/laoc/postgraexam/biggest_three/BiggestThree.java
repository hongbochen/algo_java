package site.laoc.postgraexam.biggest_three;

import java.util.Scanner;

public class BiggestThree {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int m = Integer.parseInt(scanner.nextLine());

        for(int p = 0;p < m;p++) {
            String str = scanner.nextLine();

            String strs[] = str.split(" ");
            int digits[] = new int[strs.length];

            for(int q = 0;q< strs.length;q++){
                digits[q] = Integer.parseInt(strs[q]);
            }

            int n = digits.length;
            int[] cntArr = new int[10];
            for(int i = n-1; i >= 0; i--)  cntArr[digits[i]]++;
            //9,6,3,0都可以使用
            //8,5,2是余数为2的，要看数量
            //7,4,1是余数为1的，要看数量
            int plus2Cnt = (cntArr[2]+cntArr[5]+cntArr[8])%3;
            int plus1Cnt = (cntArr[1]+cntArr[4]+cntArr[7])%3;
            //System.out.println("plus2Cnt:" + plus2Cnt + ", plus1Cnt:" + plus1Cnt);
            //余数2的数量和余数1多余的数量组合有9种
            //0,0 : 都可以使用，不需要删减
            //1,1 : 都可以使用，不需要删减
            //2,2 : 都可以使用，不需要删减
            //0,1 : 余数为1的最小的一个不能使用
            //1,2 : 余数为1的最小的一个不能使用
            if((plus2Cnt == 0 && plus1Cnt == 1) || (plus2Cnt == 1 && plus1Cnt == 2)){
                if(cntArr[1] > 0) cntArr[1]--;
                else if(cntArr[4] > 0) cntArr[4]--;
                else cntArr[7]--;
            }
            //0,2 : 余数为2的一个不能使用，如果没有则余数为1的最小的两个不能使用
            else if(plus2Cnt == 0 && plus1Cnt == 2){
                if(cntArr[2]+cntArr[5]+cntArr[8] > 0){
                    if(cntArr[2] > 0) cntArr[2]--;
                    else if(cntArr[5] > 0) cntArr[5]--;
                    else cntArr[8]--;
                }
                else{
                    while(plus1Cnt > 0){
                        if(cntArr[1] > 0) cntArr[1]--;
                        else if(cntArr[4] > 0) cntArr[4]--;
                        else cntArr[7]--;
                        plus1Cnt--;
                    }
                }
            }
            //1,0 : 余数为2的最小的一个不能使用
            //2,1 : 余数为2的最小的一个不能使用
            else if(plus2Cnt == 1 && plus1Cnt == 0 || (plus2Cnt == 2 && plus1Cnt == 1)){
                if(cntArr[2] > 0) cntArr[2]--;
                else if(cntArr[5] > 0) cntArr[5]--;
                else cntArr[8]--;
            }
            //2,0 : 余数为1的一个不能使用，如果没有则余数为2的最小的两个个不能使用
            else if(plus2Cnt == 2 && plus1Cnt == 0){
                if(cntArr[1]+cntArr[4]+cntArr[7] > 0){
                    if(cntArr[1] > 0) cntArr[1]--;
                    else if(cntArr[4] > 0) cntArr[4]--;
                    else cntArr[7]--;
                }
                else{
                    while(plus2Cnt > 0){
                        if(cntArr[2] > 0) cntArr[2]--;
                        else if(cntArr[5] > 0) cntArr[5]--;
                        else cntArr[8]--;
                        plus2Cnt--;
                    }
                }
            }
            //确认是否有前导0会出现，只有全0的时候才会
            if(cntArr[1] == 0 && cntArr[2] == 0 && cntArr[3] == 0 &&
                    cntArr[4] == 0 && cntArr[5] == 0 && cntArr[6] == 0 &&
                    cntArr[7] == 0 && cntArr[8] == 0 && cntArr[9] == 0 && cntArr[0] > 0){
                System.out.println("0");
                continue;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 9; i >= 0; i--){
                while(cntArr[i] > 0){
                    sb.append(i);
                    cntArr[i]--;
                }
            }
            System.out.println(sb.toString());
        }
    }
}
