package site.laoc.deke;

import java.util.Scanner;

public class Ques_81 {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        scanner.close();

        int ans = N,temp = 0,k = 0,j = 1;

        while(N > 0){
            // 先判断个位数字是否大于4
            if(N % 10 > 4){
                temp = temp + (N % 10 - 1) * k + j;
            }else{
                temp = temp + (N % 10) * k;
            }

            k = k * 9 + j; // k代表跳了多少次4，多收了多元个1元
            j = j * 10; // 代表位数
            N = N / 10;
        }

        System.out.println((ans - temp));
    }
}
