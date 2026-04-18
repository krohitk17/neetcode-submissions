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
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));
        for (ListNode node : lists) if (node != null) queue.add(node);

        ListNode sorted = new ListNode(), curr = sorted;
        while (queue.size() > 0) {
            ListNode smallest = queue.poll();
            curr.next = new ListNode(smallest.val);
            if (smallest.next != null) queue.add(smallest.next);
            curr = curr.next;
        }

        return sorted.next;
    }
}
