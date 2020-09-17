package pointers.fast_slow;

// Given the head of a Singly LinkedList, write a method to check if the LinkedList is a palindrome or not.
public class SingleLinkedListPalindrome {

    public static boolean isPalindrome(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode startNode = head;
        ListNode middleNode = MiddleLinkedList.findMiddle(head);
        System.out.println("middle Node : " + middleNode.value);
        ListNode reversedNode = reverseLL(middleNode);
        System.out.println("reverse Node : " + reversedNode.value);

        while (startNode != null && reversedNode != null) {
            if (!startNode.value.equals(reversedNode.value)) {
                break;
            }
            startNode = startNode.next;
            reversedNode = reversedNode.next;
        }

        return startNode == null || reversedNode == null;
    }

    public static ListNode reverseLL(ListNode head) {
        ListNode prev = null;

        while (head != null) {
            ListNode next = head.next;
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
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        System.out.println("Is Palindrome : " + SingleLinkedListPalindrome.isPalindrome(head));
        head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(2);
        System.out.println("Is Palindrome : " + SingleLinkedListPalindrome.isPalindrome(head));
    }

}
