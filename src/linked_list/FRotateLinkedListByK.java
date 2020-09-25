package linked_list;

// Given the head of a Singly LinkedList and a number ‘k’, rotate the LinkedList to the right by ‘k’ nodes.
public class FRotateLinkedListByK {

    public static ListNode rotate(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        ListNode last = head;
        ListNode current = head;
        int size = 1;
        while (last.next != null) {
            last = last.next;
            size++;
        }

        // fit k around the rotation
        if (k >= size) {
            k = k % size;
            if (k == 0) {
                return head;
            }
        }

        for (int i = 0; current != null && i < size - k - 1; i++) {
            current = current.next;
        }
        if (current == null) {
            return head;
        }
        ListNode prev = current.next;
        current.next = null;
        last.next = head;
        head = prev;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode responseHead = FRotateLinkedListByK.rotate(head, 3);
        System.out.println("Response : ");
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);

        responseHead = FRotateLinkedListByK.rotate(head2, 8);
        System.out.println("Response : ");
        while (responseHead != null) {
            System.out.println(responseHead.value + "->");
            responseHead = responseHead.next;
        }
    }

}
