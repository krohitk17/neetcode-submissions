/**
 * Definition for singly-linked list.
 * type ListNode struct {
 *     Val int
 *     Next *ListNode
 * }
 */
func reorderList(head *ListNode) {
    if head == nil || head.Next == nil {
        return
    }

    // locate mid of list
    mid, temp := head, head.Next
    for temp != nil && temp.Next != nil {
        mid = mid.Next
        temp = temp.Next.Next
    }

    // reverse second half of list
    var end *ListNode
    curr := mid.Next
    for curr != nil {
        next := curr.Next
        curr.Next = end
        end = curr
        curr = next
    }
    // disconnect both halves
    mid.Next = nil

    start := head
    // connect first node of first list to first node of second list
    // then move to next nodes of both lists
    for end != nil {
        startNext := start.Next
        endNext := end.Next

        start.Next = end
        end.Next = startNext

        start = startNext
        end = endNext
    }
}
