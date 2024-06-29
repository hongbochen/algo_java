package site.laoc.deke;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Ques_test2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();

        List<Integer> nums = Arrays.stream(line.split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        List<String> res = new ArrayList<>();


        long size = Long.MAX_VALUE;

        for(int i = 0;i < nums.size();i++){
            for(int j = i + 1; j < nums.size();j++){
                long sum = Math.abs(nums.get(i) + nums.get(j));

                if(sum < size){
                    size = sum;
                    res.clear();
                    res.add(""+nums.get(i));
                    res.add(""+nums.get(j));
                    res.add(""+sum);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        res.forEach(x -> builder.append(x).append(" "));

        System.out.println(builder.substring(0,builder.length()-1));
    }
}
