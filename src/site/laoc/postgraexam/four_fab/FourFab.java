package site.laoc.postgraexam.four_fab;

import java.util.Scanner;

public class FourFab {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for(int m = 0; m < count;m++){
            findFourFabValIndex(Integer.parseInt(scanner.nextLine()));
        }
//
        //findFourFabValIndex(25);

//        for(int i = 0;i < 30;i++){
//            System.out.println(calFourFabVal(i));
//        }

    }

    public static int findFourFabValIndex(int inval){
        int tmp = 0;

        int index = -1;

        while(tmp < inval){
            index = index + 1;
            tmp = calFourFabVal(index);
            //System.out.println("---:" + tmp);
            if(tmp == inval){
                System.out.println(index);
                return index;
            }
        }

        System.out.println(-1);
        return -1;
    }

    public static int calFourFabVal(int n) {
        if (n <= 3) {
            return 1;
        }

        int fib1 = 1;
        int fib2 = 1;
        int fib3 = 1;
        int fib4 = 1;
        for (int i = 4; i <= n; i++) {
            int fibNext = fib1 + fib2 + fib3 + fib4;
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fib4;
            fib4 = fibNext;
        }
        return fib4;
    }
}
