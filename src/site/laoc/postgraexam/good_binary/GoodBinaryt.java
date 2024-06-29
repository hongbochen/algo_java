package site.laoc.postgraexam.good_binary;

import java.util.Scanner;

public class GoodBinaryt {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

//        int q = Integer.parseInt(scanner.nextLine());
//
//        for(int p = 0;p < q;p++) {
//            String n = scanner.nextLine();
//
//            System.out.println(smallestGoodBase(n));
//        }

        String n = scanner.nextLine();

        System.out.println(smallestGoodBase(n));
    }

    public static String smallestGoodBase(String n) {
        long nVal = Long.parseLong(n);
        int mMax = (int) Math.floor(Math.log(nVal) / Math.log(2));
        for (int m = mMax; m > 1; m--) {
            int k = (int) Math.pow(nVal, 1.0 / m);
            long mul = 1, sum = 1;
            for (int i = 0; i < m; i++) {
                mul *= k;
                sum += mul;
            }
            if (sum == nVal) {
                return Integer.toString(k);
            }
        }
        return Long.toString(nVal - 1);
    }
}
