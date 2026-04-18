/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        for (Node curr = head; curr != null; curr = curr.next.next) {
            Node clone = new Node(curr.val);
            clone.next = curr.next;
            curr.next = clone;
        }

        for (Node curr = head; curr != null; curr = curr.next.next) {
            if (curr.random != null) curr.next.random = curr.random.next;
        }

        Node cloneHead = new Node(0);

        for (Node curr = head, clone = cloneHead; curr != null; curr = curr.next, clone = clone.next) {
            Node copy = curr.next;

            curr.next = copy.next;

            if (curr.next != null) copy.next = curr.next.next;
            
            clone.next = copy;
        }

        return cloneHead.next;
    }
}
