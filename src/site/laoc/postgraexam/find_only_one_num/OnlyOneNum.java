package site.laoc.postgraexam.find_only_one_num;


import java.util.Scanner;

public class OnlyOneNum {

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        for(int i = 0;i < n;i++){
            String str = scanner.nextLine();

            String strs[] = str.split(" ");

            int ret = 0;

            for(String numStr : strs){
                ret = ret ^ (Integer.parseInt(numStr));
            }

            System.out.println(ret);
        }
    }
}
