package jsr.interviewBit;

public class ReverseInGroupB {

    /**
     * Definition for singly-linked list.*/
    static class ListNode {
         public int val;
         public ListNode next;
         public ListNode(int x) { val = x; next = null; }
     }


    public static ListNode reverseList(ListNode A, int B) {

        if(A==null || A.next== null || B==1){
            return A;
        }
        ListNode node = A;
        ListNode prevNode;
        ListNode nextNode = null;

        ListNode prevtoLastNodeInSet = null;
        ListNode lastNodeInSet = null;
        ListNode head = null;

        while(node!=null){

            int count = 1;
            prevNode = node;
            node = node.next;
            if(node!=null)
                nextNode = node.next;
            lastNodeInSet = prevNode;

            while(count<B && node!=null){

                count ++;
                node.next = prevNode;
                prevNode = node;
                node = nextNode;
                if(node!=null){
                    nextNode = node.next;
                }
                else{
                    break;
                }

            }
            if(prevtoLastNodeInSet!=null){
                //node.next = prevtoLastNodeInSet;
                prevtoLastNodeInSet.next = prevNode;
            }
            else{
                head = prevNode;
            }
            prevtoLastNodeInSet = lastNodeInSet;
            prevtoLastNodeInSet.next = null;

        }
        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 =new ListNode(2);

        ListNode node3 = new ListNode(3);
        ListNode node4=new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = new ListNode(5);

        reverseList(node1, 5);

    }


}
