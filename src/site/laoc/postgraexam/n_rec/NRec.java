package site.laoc.postgraexam.n_rec;

import java.util.Scanner;

public class NRec {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int count = Integer.parseInt(scanner.nextLine());

        for(int m = 0; m < count;m++){
            int n = scanner.nextInt();

            int l = 0,r = n-1,t = 0,b = n-1;
            int num = 1,tar = n * n;

            int ret[][] = new int[n][n];

            while(num <= tar){
                //left to right
                for(int i=l; i<=r; i++)
                {
                    ret[t][i] = num++;
                }

                t++;

                //top to bottom
                for(int i=t; i<=b; i++)
                {
                    ret[i][r] = num++;
                }

                r--;

                //right to left
                for(int i=r; i>=l; i--)
                {
                    ret[b][i] = num++;
                }

                b--;

                //bottom to top
                for(int i=b; i>=t; i--)
                {
                    ret[i][l] = num++;
                }

                l++;
            }

            for(int p = 0;p < n;p++){
                for(int q = 0;q < n;q++){
                    if(q < n - 1){
                        System.out.print(ret[p][q] + " ");
                    }else{
                        System.out.print(ret[p][q]);
                    }

                }

                if(p < n - 1){
                    System.out.print(",");
                }

            }

            System.out.println();
        }
    }
}
