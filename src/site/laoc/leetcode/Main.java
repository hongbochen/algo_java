package site.laoc.leetcode;

import java.util.Base64;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
       String Card = "YWJjZGVmZ2hpamsxMjM0NTY3OA==";

        byte[] bytes = Base64.getDecoder().decode(Card);

        System.out.println(new String(bytes));
    }
}
