package site.laoc.postgraexam.five_fab;

import java.util.Scanner;

public class FiveFab {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        /**
        int count = Integer.parseInt(scanner.nextLine());

        for(int m = 0; m < count;m++){
            findFiveFabValIndex(Integer.parseInt(scanner.nextLine()));
        }**/

        findFiveFabValIndex(Integer.parseInt(scanner.nextLine()));

    }

    public static int findFiveFabValIndex(int inval){
        int tmp = 0;

        int index = -1;

        while(tmp < inval){
            index = index + 1;
            tmp = calFiveFabVal(index);
            //System.out.println("---:" + tmp);
            if(tmp == inval){
                System.out.println(index);
                return index;
            }
        }

        System.out.println(-1);
        return -1;
    }

    public static int calFiveFabVal(int n) {
        if (n <= 4) {
            return 1;
        }

        int fib1 = 1;
        int fib2 = 1;
        int fib3 = 1;
        int fib4 = 1;
        int fib5 = 1;
        for (int i = 5; i <= n; i++) {
            int fibNext = fib1 + fib2 + fib3 + fib4 + fib5;
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib4;
            fib4 = fib5;
            fib5 = fibNext;
        }
        return fib5;
    }
}
