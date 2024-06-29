package site.laoc.deke;

/*
   某学校举行运动会,学生们按编号（1、2、3.....n)进行标识,
   现需要按照身高由低到高排列，
   对身高相同的人，按体重由轻到重排列，
   对于身高体重都相同的人，维持原有的编号顺序关系。
   请输出排列后的学生编号
   输入描述：
      两个序列，每个序列由N个正整数组成，(0<n<=100)。
      第一个序列中的数值代表身高，第二个序列中的数值代表体重，
   输出描述：
      排列结果，每个数据都是原始序列中的学生编号，编号从1开始，
   实例一：
      输入:
       4
       100 100 120 130
       40 30 60 50
      输出:
       2134
   */

import java.util.LinkedList;
import java.util.Scanner;

public class Ques_79 {
    static class Stu{
        int nums;
        int weight;
        int height;

        public Stu(int nums,int weight,int height){
            this.nums = nums;
            this.weight = weight;
            this.height = height;
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String heis = scanner.nextLine();
        String weis = scanner.nextLine();
        scanner.close();

        String[] hs = heis.split(" ");
        String[] ws = weis.split(" ");

        LinkedList<Stu> stuList = new LinkedList<>();

        for(int i = 0;i < n;i++){
            Stu stu = new Stu(i+1,Integer.parseInt(ws[i]),Integer.parseInt(hs[i]));
            stuList.add(stu);
        }

        stuList.sort((o1,o2)->o1.height == o2.height ? (o1.weight - o2.weight) : (o1.height - o2.height));
        StringBuilder sb = new StringBuilder();

        stuList.forEach(x -> sb.append(x.nums).append(" "));
        System.out.println(sb.substring(0,sb.length()-1));
    }
}
