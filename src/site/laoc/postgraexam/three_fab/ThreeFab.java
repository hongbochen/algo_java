package site.laoc.postgraexam.three_fab;

import java.util.Scanner;

public class ThreeFab {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for(int m = 0; m < count;m++){
            findThreeFabValIndex(Integer.parseInt(scanner.nextLine()));
        }

        //findThreeFabValIndex(57);
//
//        for(int i = 0;i < 30;i++){
//            System.out.println(calThreeFabVal(i));
//        }

    }

    public static int findThreeFabValIndex(int inval){
        int tmp = 0;

        int index = -1;

        while(tmp < inval){
            index = index + 1;
            tmp = calThreeFabVal(index);
            //System.out.println("---:" + tmp);
            if(tmp == inval){
                System.out.println(index);
                return index;
            }
        }

        System.out.println(-1);
        return -1;
    }

    public static Integer calThreeFabVal(int n){
        if (n <= 2) {
            return 1;
        }

        int fib1 = 1;
        int fib2 = 1;
        int fib3 = 1;
        for (int i = 3; i <= n; i++) {
            int fibNext = fib1 + fib2 + fib3;
            fib1 = fib2;
            fib2 = fib3;
            fib3 = fibNext;
        }
        return fib3;
    }
}
