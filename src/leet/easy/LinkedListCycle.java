package easy;

public class LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
          val = x;
          next = null;
        }
    }
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode low = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            low = low.next;
            if(fast == low) {
                return true;
            }
        }

        return false;
    }
}
