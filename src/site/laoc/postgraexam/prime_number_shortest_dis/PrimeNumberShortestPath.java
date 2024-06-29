package site.laoc.postgraexam.prime_number_shortest_dis;

import java.util.Scanner;

public class PrimeNumberShortestPath {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

//        int count = Integer.parseInt(scanner.nextLine());
//
//        for(int m = 0; m < count;m++){
//            Integer N = Integer.parseInt(scanner.nextLine());
//            System.out.println(getShortestLen(N));
//        }

        Integer N = Integer.parseInt(scanner.nextLine());
        System.out.println(getShortestLen(N));

    }

    public static int getShortestLen(int N){
        if(isPrimeNumber(N)){
            return 0;
        }

        // 向右找最小的质数
        int tmp = N;
        while(!isPrimeNumber(tmp)){
            tmp++;
        }

        int rl = tmp - N;

        // 向左找最小质数
        int ltmp = N;
        while(!isPrimeNumber(ltmp) && ltmp >= 1){
            ltmp--;
        }

        int ll = N - ltmp;

        if(rl > ll){
            return ll;
        }else{
            return rl;
        }
    }

    public static boolean isPrimeNumber(int num){
        for(int i = 1;i <= num;i++){
            if(num % i == 0 && i != 1 && i != num){
                return false;
            }
        }

        return true;
    }
}
