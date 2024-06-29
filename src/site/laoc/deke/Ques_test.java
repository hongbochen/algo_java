package site.laoc.deke;

import java.util.*;
import java.util.stream.Collectors;

public class Ques_test {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> list = new LinkedList<>();

        for(int i = 0;i < n;i++){
            list.add(scanner.nextLine());
        }

        scanner.close();

        list = list.stream().sorted((o1,o2) -> {
            return getTime(o1) - getTime(o2);
        }).collect(Collectors.toList());

        for(String str : list){
            System.out.println(str);
        }
    }

    static int getTime(String str){
        String strs1[] = str.split(":");
        String strs2[] = strs1[2].split("\\.");

        int h = Integer.parseInt(strs1[0]) * 60 * 60 * 1000;
        int m = Integer.parseInt(strs1[1]) * 60 * 1000;
        int s = Integer.parseInt(strs2[0]) * 1000;
        int ms = Integer.parseInt(strs2[1]);

        return h + m + s + ms;
    }
}
