package site.laoc.leetcode.middle_of_linked_list;

public class MiddleOfLinkedList {

    public ListNode middleNode(ListNode head) {
        int size = 0;

        ListNode cur = head;

        while(cur != null){
            size++;
            cur = cur.next;
        }

        int middle = size / 2;

        cur = head;
        for(int i = 0;i < middle;i++){
            cur = cur.next;
        }

        return cur;
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
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;

        MiddleOfLinkedList middleOfLinkedList = new MiddleOfLinkedList();
        ListNode node = middleOfLinkedList.middleNode(node1);

        printList(node);
    }
}
