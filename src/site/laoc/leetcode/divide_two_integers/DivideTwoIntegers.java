package site.laoc.leetcode.divide_two_integers;

import com.sun.imageio.plugins.common.I18N;

/**
 * 这种方法无论怎么调试，总是达不到预期的时间要求
 */
public class DivideTwoIntegers {
    public int divide(int dividend, int divisor) {
        long di1 = dividend;
        long di2 = divisor;

        if(di1 < 0){
            di1 = 0 - di1;
        }

        if(di2 < 0){
            di2 = 0 - di2;
        }

        if(di1 < di2){
            return 0;
        }

        long size = -1;
        do{
            di1 = di1 - di2 - di2 - di2 - di2;
            size++;
            size++;
            size++;
            size++;
        }while(di1 >= 0);

        if(di1 + di2 + di2 + di2< 0){
            size--;
        }

        if(di1 + di2 + di2< 0){
            size--;
        }

        if(di1 + di2 < 0){
            size--;
        }

        if(dividend > 0 && divisor > 0){
            if(size > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)size;
            }
        }else if(dividend < 0 && divisor > 0){
            if(0 - size < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return (int)(0 - size);
            }
        }else if(dividend > 0 && divisor < 0){
            if(0 - size < Integer.MIN_VALUE){
                return Integer.MIN_VALUE;
            }else{
                return (int)(0 - size);
            }
        }else{
            if(size > Integer.MAX_VALUE){
                return Integer.MAX_VALUE;
            }else{
                return (int)size;
            }
        }
    }

    public static void main(String args[]){
        DivideTwoIntegers divideTwoIntegers = new DivideTwoIntegers();
        //divideTwoIntegers.divide(-2147483648,-1);
        long startTime = System.currentTimeMillis();
        System.out.println(divideTwoIntegers.divide(-2147483648,2));
        long endTime = System.currentTimeMillis();
        System.out.println("程序运行时间：" + (endTime - startTime) + "ms");


//        int num1 = 10;
//
//        int num3 =  num1 >> 1;
//        System.out.println(num3);
    }
}