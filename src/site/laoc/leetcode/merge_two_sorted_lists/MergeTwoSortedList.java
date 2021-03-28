package site.laoc.leetcode.merge_two_sorted_lists;

import javax.swing.*;

public class MergeTwoSortedList {

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        if(l1 == null){
            return l2;
        }

        ListNode node1 = l1;
        ListNode node2 = l2;

        ListNode pre = null;

        ListNode head = node1;

        while(node1 != null){
            //System.out.println("node1 = " + node1.val);

            while(node2 != null && node2.val <= node1.val){
                //System.out.println("    node2 = " + node2.val);

                ListNode tmp = new ListNode(node2.val,node1);

                if(pre == null){
                    pre = tmp;
                    head = pre;
                }else{
                    pre.next = tmp;
                    pre = tmp;
                }

                node2 = node2.next;
            }

            pre = node1;
            node1 = node1.next;
        }

        if(node2 != null){
            pre.next = node2;
        }

        return head;
    }

    public void printList(ListNode head){
        ListNode node = head;

        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }

        System.out.println();
    }

    public static void main(String [] args){
//        ListNode l1 = new ListNode(1,null);
//        ListNode l11 = new ListNode(2,null);
//        ListNode l12 = new ListNode(4,null);
//        l1.next = l11;
//        l11.next = l12;
//
//        ListNode l2 = new ListNode(1,null);
//        ListNode l21 = new ListNode(3,null);
//        ListNode l22 = new ListNode(4,null);
//        l2.next = l21;
//        l21.next = l22;
//
//
//        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
//        mergeTwoSortedList.printList(l1);
//        mergeTwoSortedList.printList(l2);
//        ListNode node = mergeTwoSortedList.mergeTwoLists(l1,l2);
//
//        mergeTwoSortedList.printList(node);

        ListNode l1 = new ListNode(1,null);

        ListNode l2 = new ListNode(2,null);
        ListNode l21 = new ListNode(3,null);
        ListNode l22 = new ListNode(4,null);
        l2.next = l21;
        l21.next = l22;


        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        ListNode node = mergeTwoSortedList.mergeTwoLists(l1,l2);

        mergeTwoSortedList.printList(node);
    }
}
