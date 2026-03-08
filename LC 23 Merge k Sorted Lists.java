// LC 23 Merge k Sorted Lists

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a,b) -> a.val - b.val);

        for(ListNode node : lists){
            if(node != null) pq.offer(node);
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            cur.next = node;
            cur = cur.next;

            if(node.next != null)
                pq.offer(node.next);
        }

        return dummy.next;
    }
}  
