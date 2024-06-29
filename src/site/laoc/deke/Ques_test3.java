package site.laoc.deke;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ques_test3 {

    static class Node{
        int num;
        List<Node> next;
        List<Node> pre;

        public Node(int num,List<Node> next,List<Node> pre){
            this.num = num;
            this.next = next;
            this.pre = pre;
        }

        @Override
        public String toString() {
            return "" + num;
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

        List<Node> nodes = new ArrayList<>();
        for(int i = 0;i < n;i++){
            Node node = new Node(i+1,new ArrayList<>(),new ArrayList<>());
            nodes.add(node);
        }

        for(int i = 0;i < paths.size();i++){
            String strs[] = paths.get(i).split(" ");
            int start = Integer.parseInt(strs[0]);
            int end = Integer.parseInt(strs[1]);

            List<Node> nds = nodes.get(start-1).next;
            nds.add(nodes.get(end-1));

            List<Node> nds2 = nodes.get(start-1).pre;
            nds2.add(nodes.get(end-1));

            List<Node> nds1 = nodes.get(end-1).pre;
            nds1.add(nodes.get(start-1));

            List<Node> nds3 = nodes.get(end-1).next;
            nds3.add(nodes.get(start-1));
        }

        Node tnode = nodes.get(2);

        int max = 0;

        for(int i = 0;i < nodes.size();i++){
            // 如果切断某一个
            Node cur = nodes.get(i);

            List<Node> list = getAllSurroundNodes(cur);
            System.out.println("i =========== " + (i+1));
            for(Node innode : list){
                System.out.print(innode + "--" + (getNextAllNodes(cur,innode) + getPreAllNodes(cur,innode)) +"  ");
            }
            System.out.println();

        }


    }

    private static List<Node> getAllSurroundNodes(Node node){
        List<Node> list = new ArrayList<>();
        for(Node innode : node.next){
            list.add(innode);
        }

        for(Node innode : node.pre){
            list.add(innode);
        }

        return list;
    }

    private static int getNextAllNodes(Node not,Node node){
        int all = 0;

        for(Node nd : node.next){
            if(nd != not){

                all = all + 1;
                int size1 = getNextAllNodes(not,nd);
                int size2 = getPreAllNodes(not,nd);

                all = all + size1 + size2;
            }
        }

        return all;
    }

    private static int getPreAllNodes(Node not,Node node){
        int all = 0;

        for(Node nd : node.pre){
            if(nd != not){

                all = all + 1;
                int size1 = getNextAllNodes(not,nd);
                int size2 = getPreAllNodes(not,nd);

                all = all + size1 + size2;
            }
        }

        return all;
    }
}
