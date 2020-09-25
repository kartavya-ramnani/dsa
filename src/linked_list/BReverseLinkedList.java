package linked_list;

// Given the head of a Singly LinkedList, reverse the LinkedList.
// Write a function to return the new head of the reversed LinkedList.
public class BReverseLinkedList {

    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode prev = null;
        ListNode next;

        while (head != null) {
            next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        ListNode responseHead = BReverseLinkedList.reverse(head);
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }
    }

}
