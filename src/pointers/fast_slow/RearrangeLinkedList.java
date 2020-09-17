package pointers.fast_slow;

//Given the head of a Singly LinkedList, write a method to modify the LinkedList such that
// the nodes from the second half of the LinkedList are inserted alternately to the nodes from the first half in reverse order.
// So if the LinkedList has nodes 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> null, your method should return 1 -> 6 -> 2 -> 5 -> 3 -> 4 -> null.
// Your algorithm should not use any extra space and the input LinkedList should be modified in-place.
public class RearrangeLinkedList {

    public static ListNode reorder(ListNode head) {
        ListNode start = head;
        ListNode middle = MiddleLinkedList.findMiddle(head);
        ListNode reverse = SingleLinkedListPalindrome.reverseLL(middle);
        while (start != null && reverse != null) {
            ListNode next = start.next;
            ListNode nextRev = reverse.next;
            start.next = reverse;
            reverse.next = next;
            start = next;
            reverse = nextRev;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        ListNode responseHead = RearrangeLinkedList.reorder(head);
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }
    }

}
