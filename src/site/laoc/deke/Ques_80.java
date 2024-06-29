package site.laoc.deke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
        给定参数n,从1到n会有n个整数:1,2,3,...,n,
        这n个数字共有n!种排列.
      按大小顺序升序列出所有排列的情况,并一一标记,
      当n=3时,所有排列如下:
      "123" "132" "213" "231" "312" "321"
      给定n和k,返回第k个排列.

      输入描述:
        输入两行，第一行为n，第二行为k，
        给定n的范围是[1,9],给定k的范围是[1,n!]。
      输出描述：
        输出排在第k位置的数字。

      实例1：
        输入:
          3
          3
        输出：
          231
        说明
          3的排列有123,132,213...,那么第三位置就是213

      实例2：
        输入
          2
          2
        输出：
          21
        说明
          2的排列有12,21，那么第二位置的为21
   */
public class Ques_80 {

    public static void main(String args[]){
        // 全排列
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int k = Integer.parseInt(scanner.nextLine());

        StringBuilder sb = new StringBuilder();

        // 阶乘数
        int facs[] = new int[n+1];
        // 剩余待选择的数
        List<Integer> candidates = new ArrayList<>();
        facs[0] = 1;
        int d = 1;

        for(int i = 1;i <= n;i++){
            candidates.add(i);
            d = d * i;
            facs[i] = d;
        }

        k--;
        for(int j = n -1;j >= 0;j--){
            int index = k / facs[j];
            sb.append(candidates.remove(index));
            k -= index * facs[j];
        }

        System.out.println(sb.toString());
    }

}
