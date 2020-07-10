public class Solution2 {

    // 递归解法
    public ListNode reverseList(ListNode head) {
        // 递归终止操作
//        if(head == null || head.next == null) {
//            return head;
//        }
//
//        // p 指向的链表已完成反转
//        ListNode p = reverseList(head.next);
//
//        // 基本操作
//        head.next.next = head;
//        head.next = null;
//
//        return p;
        // 递归终止条件
        if(head.next == null) {
            return head;
        }

        ListNode p = reverseList(head.next);

        return p;
    }


}
