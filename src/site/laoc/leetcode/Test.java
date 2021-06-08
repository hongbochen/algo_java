package site.laoc.leetcode;

import java.util.Scanner;

public class Test {
    public static void main(String[] args){
        String line = "W60b44972e4b0b8fbd83fbfd0|10001004989022|3|3142000|3142000|1||2021053111411341104802|3141900|100||";

        String tmps[] = line.split("\\|");

        if(tmps.length != 10){
            System.out.println("数组数量不够10个");
        }


        for(int i = 0;i < tmps.length;i++){
            System.out.println(i + "-------------" + tmps[i]);
        }

//        String tradeNo = tmps[0];
//        String state = tmps[6];
//        String unionTradeNo = tmps[7];
//        String unionPrice = tmps[8];
//        String servicePrice = tmps[9];
    }
}
