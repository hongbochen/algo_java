package site.laoc.leetcode.remove_Nth_node_from_end_of_list;

public class RemoveNthNodeFromEndOfList {

      public static class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;

        ListNode node = head;

        while(node != null){
            size = size + 1;
            node = node.next;
        }

        int steps = size - n;

        node = head;
        ListNode preNode = null;

        for(int i = 0;i < steps;i++){
            preNode = node;
            node = node.next;
        }

        if(preNode == null && node == head){
            head = node.next;
        }else{
            preNode.next = node.next;
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
        ListNode listNode1 = new ListNode(1,null);
//        ListNode listNode2 = new ListNode(2,null);
//        ListNode listNode3 = new ListNode(3,null);
//        ListNode listNode4 = new ListNode(4,null);
//        ListNode listNode5 = new ListNode(5,null);

 //       listNode1.next = listNode2;
//        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        RemoveNthNodeFromEndOfList removeNthNodeFromEndOfList = new RemoveNthNodeFromEndOfList();
        //removeNthNodeFromEndOfList.printList(listNode1);
        ListNode node = removeNthNodeFromEndOfList.removeNthFromEnd(listNode1,2);
        removeNthNodeFromEndOfList.printList(node);
    }
}
