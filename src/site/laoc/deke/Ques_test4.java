package site.laoc.deke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ques_test4 {

    static class Node{
        int start;
        int end;

        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        List<String> paths = new ArrayList<>();

        for(int i = 0;i < n-1;i++){
            paths.add(scanner.nextLine());
        }

        scanner.close();

        List<Node> list = new ArrayList<>();

        for(int i = 0;i < paths.size();i++){
            String strs[] = paths.get(i).split(" ");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);

            list.add(new Node(start,end));
        }

        List<Integer> res = new ArrayList<>();

        for(int i = 1;i <= n;i++){
            // 删除i
            List<Integer> snodes = new ArrayList<>();

            for(Node node : list){
                if(node.start == i){
                    snodes.add(node.end);
                }

                if(node.end == i){
                    snodes.add(node.start);
                }
            }

            System.out.println(snodes);

            int max = 0;
            for(int m = 0;m < snodes.size();m++){
                int com = snodes.get(m);

                String hh = "";
                for(int p = 0;p < 2;p++){
                    for(Node innode : list){
                        if(innode.start == com && innode.end != i){
                            if(!hh.contains(""+innode.end)){
                                hh = hh + innode.end;
                            }

                        }

                        if(innode.end == com && innode.start != i){
                            if(!hh.contains(""+innode.start)){
                                hh = hh + innode.start;
                            }

                        }

                        if(innode.start != com && innode.end != com && hh.contains(""+innode.start) && innode.end != i){
                            if(!hh.contains(""+innode.end)){
                                hh = hh + innode.end;
                            }
                        }

                        if(innode.start != com && innode.end != com && hh.contains(""+innode.end) && innode.start != i){
                            if(!hh.contains(""+innode.start)){
                                hh = hh + innode.start;
                            }
                        }
                    }
                }


                if(hh.length() > max){
                    max = hh.length() + 1;

                }
            }

            res.add(max);

        }

        System.out.println(res);
    }

}
