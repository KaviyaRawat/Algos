package jsr.interviewBit;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKSortedHeap {
    class ListNode {
      public int val;
      public ListNode next;
      ListNode(int x) { val = x; next = null; }
  }
    public class IndexValue{
            int val;
            int index;
            IndexValue(int v, int i){
                val = v;
                index = i;
            }

    }

    public class Solution {
        public ListNode mergeKLists(ArrayList<ListNode> a) {


            Queue<IndexValue> q = new PriorityQueue((Comparator<IndexValue>) (o1, o2) -> Integer.valueOf(o1.val).compareTo(o2.val));

            for(int i=0; i<a.size(); i++){
                if(a.get(i)!=null) {
                    q.add(new IndexValue(a.get(i).val, i));
                    a.set(i, a.get(i).next);
                }
            }

            ListNode head = new ListNode(q.poll().val);
            ListNode temp = head;
            while(!q.isEmpty()){
                IndexValue val = q.poll();
                temp.next = new ListNode(val.val);
                if(a.get(val.index)!=null){
                    q.add(new IndexValue(a.get(val.index).val, val.index));
                    a.set(val.index, a.get(val.index).next);
                }
                temp = temp.next;
            }



            return head;

        }
    }




}
