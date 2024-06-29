package site.laoc.deke;

import java.util.Scanner;

public class Ques_81_1 {
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int nums = scanner.nextInt();

        int tmps = 0;
        for(int i = 1;i <= nums;i++){
            String tt = ""+i;

            if(tt.contains("4")){
                tmps++;
            }
        }

        int res = nums - tmps;
        System.out.println(res);
    }
}
