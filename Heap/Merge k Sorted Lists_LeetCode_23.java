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

        PriorityQueue<ListNode> heap = new PriorityQueue<>((n1,n2)->n1.val-n2.val);

        for(int i=0;i<lists.length;i++){

            ListNode node = lists[i];

            while(node!=null){
                heap.add(node);
                node= node.next;
            }

        }

        ListNode start = heap.poll();
        ListNode head = start;
        while(!heap.isEmpty()){

            ListNode node = heap.poll();
            node.next=null;
           System.out.println(node.val);
            start.next = node;
            start = node;
        }

        return head;
        
    }
}