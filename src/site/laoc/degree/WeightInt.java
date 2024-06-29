package site.laoc.degree;

import java.util.Scanner;

public class WeightInt {

    public static boolean isPowerOfFour(int n) {
        return n > 0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }

    public void avg(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            int n = scanner.nextInt();

            int nums[] = new int[n];
            double weights[] = new double[n];

            for(int i = 0;i < n;i++){
                nums[i] = scanner.nextInt();
            }

            for(int i = 0;i < n;i++){
                weights[i] = scanner.nextDouble();
            }

            double val = 0D;

            for(int i = 0;i < n;i++){
                val = val + nums[i] * weights[i];
            }

            val = val / n;

            System.out.println(DoubleUtil.round(val,2));
        }
    }

    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for(int i = 0;i < n;i++){
            int h = scanner.nextInt();
            System.out.println(isPowerOfFour(h));
        }
    }
}
