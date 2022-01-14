package site.laoc.leetcode.remove_Nth_node_from_endOfList;


import java.util.List;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode cur = head;

        while(cur != null){
            size++;
            cur = cur.next;
        }

        int index = size - n;

        cur = head;
        ListNode pre = null;
        for(int i = 0;i < index;i++){
            pre = cur;
            cur = cur.next;
        }

        if(pre == null){
            return cur.next;
        }else{
            pre.next = cur.next;
        }

        return head;
    }

    public static void printList(ListNode node){
        ListNode cur = node;

        while(cur != null){
            System.out.print(cur.val + " ");

            cur = cur.next;
        }

        System.out.println();
    }

    public static void main(String args[]){

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        //ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        //node5.next = node6;

        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        ListNode node =  removeNthNodeFromEndOfList.removeNthFromEnd(node1,1);

        printList(node);
    }
}
