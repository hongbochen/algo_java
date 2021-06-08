package site.laoc.leetcode.mergedKSortedLists;

import java.util.List;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode outList = null;

        for(int i = 0;i < lists.length;i++){
            ListNode inlist = lists[i];

            outList = mergeTwoLists(outList,inlist);
        }

        return outList;
    }

    public ListNode mergeTwoLists(ListNode firstList, ListNode secondList){
        // 判断两个串是否为空
        if(firstList == null && secondList == null){
            return null;
        }else{
            if(firstList == null){
                return secondList;
            }

            if(secondList == null){
                return firstList;
            }
        }

        ListNode curNode = firstList;
        ListNode preNode = null;
        ListNode rootNode = firstList;

        ListNode runingNode = secondList;

        while(runingNode != null){

            ListNode nextNode = runingNode.next;

            if(curNode == null || runingNode.val <= curNode.val){
                // 插入到前面
                if(preNode == null){
                    runingNode.next = curNode;
                    preNode = runingNode;
                    rootNode = runingNode;
                }else{
                    runingNode.next = curNode;
                    preNode.next = runingNode;
                    preNode = runingNode;
                }
            }else{
                while(curNode != null && runingNode.val > curNode.val){
                    preNode = curNode;
                    curNode = curNode.next;
                }

                runingNode.next = curNode;
                preNode.next = runingNode;
                preNode = runingNode;
            }

            runingNode = nextNode;
        }

        return rootNode;
    }

    public void printList(ListNode list){
        ListNode start = list;

        while(start != null){
            System.out.print(start.val + " ");
            start = start.next;
        }

        System.out.println();
    }

    public static void main(String args[]){
        MergeKSortedLists main = new MergeKSortedLists();

//        ListNode firstList = new ListNode(1);
//        firstList.next = new ListNode(4);
//        firstList.next.next = new ListNode(5);
//
//        ListNode secondList = new ListNode(1);
//        secondList.next = new ListNode(3);
//        secondList.next.next = new ListNode(4);

        ListNode tmpList = new ListNode(1);
        tmpList.next = new ListNode(1);
        tmpList.next.next = new ListNode(3);
        tmpList.next.next.next = new ListNode(4);
        tmpList.next.next.next.next = new ListNode(4);
        tmpList.next.next.next.next.next = new ListNode(5);

        ListNode thirdList = new ListNode(2);
        thirdList.next = new ListNode(6);

        ListNode[] lists = {tmpList,thirdList};

        ListNode start = main.mergeTwoLists(tmpList,thirdList);
        main.printList(start);
    }
}
