package site.laoc.leetcode.swap_nodes_in_pairs;

import java.util.List;

public class SwapNodesInPairs {

    // 1->2->3->4->5->6
    // 2->1->4->3->6->5

    public ListNode swapPairs(ListNode head) {

        int size = 0;

        ListNode curNode = head;

        while(curNode != null){
            size++;
            curNode = curNode.next;
        }

        if(size == 0 || size == 1) {
            return head;
        }

        ListNode nodes[] = new ListNode[size];

        curNode = head;
        int index = 0;
        while(curNode != null){
            nodes[index] = curNode;
            curNode = curNode.next;
            index++;
        }

        // 1->2->3->4->5->6
        // 2->1->4->3->6->5
        for(int i = 0;i < nodes.length;i++){
            if(i % 2 == 1){
                nodes[i].next = nodes[i-1];

                if(i+1 >= size){
                    nodes[i-1].next = null;
                }else if(i + 2 >= size){
                    nodes[i-1].next = nodes[i+1];
                }else {
                    nodes[i - 1].next = nodes[i + 2];
                }
            }
        }

        return nodes[1];
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
        //ListNode node4 = new ListNode(4,null);

        node1.next = node2;
        node2.next = node3;
        //node3.next = node4;

        SwapNodesInPairs swapNodesInPairs  = new SwapNodesInPairs();
        swapNodesInPairs.printList(node1);

        ListNode newNode = swapNodesInPairs.swapPairs(node1);
        swapNodesInPairs.printList(newNode);
    }
}
