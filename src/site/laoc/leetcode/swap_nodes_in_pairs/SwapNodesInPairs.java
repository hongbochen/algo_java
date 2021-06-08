package site.laoc.leetcode.swap_nodes_in_pairs;

import java.util.List;

public class SwapNodesInPairs {

    // 1->2->3->4->5->6
    // 2->1->4->3->6->5

    public ListNode swapPairs(ListNode head) {
        ListNode lastNode = null;
        ListNode newStart = null;

        int i = 1;
        ListNode cur = head;
        ListNode lastLastCoun = null;

        while(cur != null){
            lastNode = cur;
            cur = cur.next;
            i++;

            if(i % 2 == 0){
                if(lastNode != null){
                    System.out.println("cur = " + cur.val + ";pre = " + lastNode.val + ";next=" + cur.next == null ? "-1": cur.next.val);
                }else{
                    System.out.println("cur = " + cur.val + ";pre = " + -1 + ";next=" + cur.next == null ? "-1": cur.next.val);
                }

                // 交换
                ListNode curNext = cur.next;

                cur.next = lastNode;
                cur = lastNode;
                cur.next = curNext;

                if(lastLastCoun != null){
                    lastLastCoun.next = cur;
                }else{
                    newStart = cur;
                }

                lastLastCoun = lastNode;
            }
        }

        return newStart;
    }

    public void printList(ListNode listNode){
        ListNode cur = listNode;

        while(cur != null){
            System.out.print(cur.val);
            cur = cur.next;
        }

        System.out.println();
    }

    public static void main(String [] args){
        ListNode node1 = new ListNode(1,null);
        ListNode node2 = new ListNode(2,null);
        ListNode node3 = new ListNode(3,null);
        ListNode node4 = new ListNode(4,null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        SwapNodesInPairs swapNodesInPairs  = new SwapNodesInPairs();
        swapNodesInPairs.printList(node1);

        ListNode newNode = swapNodesInPairs.swapPairs(node1);
        swapNodesInPairs.printList(newNode);
    }
}
