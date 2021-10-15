package site.laoc.leetcode.reverse_nodes_in_k_group;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {

        int size = 0;

        ListNode cur = head;

        while(cur != null){
            size++;
            cur = cur.next;
        }

        ListNode [] nodes = new ListNode[size];

        cur = head;

        size = 0;
        while(cur != null){
            nodes[size] = cur;
            size++;
            cur = cur.next;
        }

        for(int i = 1;i <= nodes.length;i++){
            if(i != 0 && i % k == 0){
                int m = i - k;
                int n = i - 1;

                while(m <= n){
                    swap(nodes,m,n);
                    m++;
                    n--;
                }
            }
        }

        for(int i = 0;i < nodes.length;i++){
            if(i+1 >= nodes.length){
                nodes[i].next = null;
            }else{
                nodes[i].next = nodes[i+1];
            }
        }

        return nodes[0];
    }

    private void swap(ListNode[] nodes,int m,int n){
        ListNode node = nodes[m];
        nodes[m] = nodes[n];
        nodes[n] = node;
    }

    private void printList(ListNode node){
        ListNode cur = node;

        while(cur != null){
            System.out.print(cur.val + " ");

            cur = cur.next;
        }

        System.out.println();
    }

    public static void main(String args[]){
        ListNode l1 = new ListNode(1,null);
        ListNode l2 = new ListNode(2,null);
        ListNode l3 = new ListNode(3,null);
        ListNode l4 = new ListNode(4,null);
        ListNode l5 = new ListNode(5,null);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReverseNodesInKGroup reverseNodesInKGroup = new ReverseNodesInKGroup();
        //reverseNodesInKGroup.printList(l1);
        reverseNodesInKGroup.reverseKGroup(l1,3);
    }
}
