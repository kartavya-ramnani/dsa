package pointers.fast_slow;

import org.w3c.dom.NodeList;

import java.util.LinkedList;

class ListNode {
    ListNode next;
    Integer value;

    ListNode(Integer value) {
        this.value = value;
    }
}

// Given the head of a Singly LinkedList, write a function to determine if the LinkedList has a cycle in it or not.
// If we know the length of the LinkedList cycle, we can find the start of the cycle through the following steps:
//
//Take two pointers. Let’s call them pointer1 and pointer2.
//
//Initialize both pointers to point to the start of the LinkedList.
//
//We can find the length of the LinkedList cycle using the approach discussed in LinkedList Cycle.
// Let’s assume that the length of the cycle is ‘K’ nodes.
//
//Move pointer2 ahead by ‘K’ nodes.
//
//Now, keep incrementing pointer1 and pointer2 until they both meet.
//
//As pointer2 is ‘K’ nodes ahead of pointer1, which means, pointer2 must have completed one loop in the cycle when both pointers meet.
//Their meeting point will be the start of the cycle.
public class LinkedListCycle {

    public static boolean doesLoopExist(ListNode headNode) {
        ListNode slowNode = headNode;
        ListNode fastNode = headNode;
        boolean hasCycle = false;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (slowNode == fastNode) {
                hasCycle = true;
                break;
            }
        }

        return hasCycle;
    }

    public static int cycleLength(ListNode headNode) {
        ListNode slowNode = headNode;
        ListNode fastNode = headNode;
        boolean hasCycle = false;

        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;

            if (slowNode == fastNode) {
                hasCycle = true;
                break;
            }
        }

        int cycleLength = 0;

        if (hasCycle) {
            ListNode tempNode = slowNode.next;
            cycleLength++;
            while (tempNode != slowNode) {
                tempNode = tempNode.next;
                cycleLength++;
            }
        }
        return cycleLength;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        System.out.println("Has Cycle : " + LinkedListCycle.doesLoopExist(head) + " with the length : " + LinkedListCycle.cycleLength(head));

        head.next.next.next.next.next.next = head.next.next;
        System.out.println("Has Cycle : " + LinkedListCycle.doesLoopExist(head) + " with the length : " + LinkedListCycle.cycleLength(head));

        head.next.next.next.next.next.next = head.next.next.next;
        System.out.println("Has Cycle : " + LinkedListCycle.doesLoopExist(head) + " with the length : " + LinkedListCycle.cycleLength(head));

    }
}
