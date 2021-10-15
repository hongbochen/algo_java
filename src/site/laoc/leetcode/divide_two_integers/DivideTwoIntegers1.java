package site.laoc.leetcode.divide_two_integers;

public class DivideTwoIntegers1 {

    public int divide(int dividend, int divisor) {
        int sign = dividend > 0 ^ divisor > 0 ? -1 : 1;

        if(dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }

        long dvd = dividend;
        long dvs = divisor; // 除数

        if(dvd < 0){
            dvd = -dvd;
        }

        if(dvs < 0){
            dvs = -dvs;
        }

        long res = 0;

        // 当被除数大于除数时
        while(dvd >= dvs){
            long tmp = dvs, m = 1;

            while((tmp << 1) <= dvd){
                tmp <<= 1;  // 除数 x 2
                m <<= 1;
            }

            dvd = dvd - tmp;
            res += m;
        }

        return (int)(sign*res);
    }

    public static void main(String args[]){
        DivideTwoIntegers1 divideTwoIntegers1 = new DivideTwoIntegers1();
        System.out.println(divideTwoIntegers1.divide(-2147483648,1));
    }
}
