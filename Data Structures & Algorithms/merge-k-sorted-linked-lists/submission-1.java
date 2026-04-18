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
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];
        return divide(lists, 0, lists.length-1);
    }

    ListNode divide(ListNode[] lists, int l, int r) {
        if (l > r) return null;
        if (l == r) return lists[l];
        int m = (l+r)/2;

        ListNode first = divide(lists, l, m);
        ListNode second = divide(lists, m+1, r);

        return conquer(first, second);
    }

    ListNode conquer(ListNode a, ListNode b) {
        ListNode head = new ListNode(), curr = head;
        while (a != null && b != null) {
            ListNode node = new ListNode();
            if (a.val < b.val) {
                node.val = a.val;
                a = a.next;
            } else {
                node.val = b.val;
                b = b.next;
            }
            curr.next = node;
            curr = curr.next;
        }
        if (a != null) curr.next = a;
        if (b != null) curr.next = b;

        return head.next;
    }
}
