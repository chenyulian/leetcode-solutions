package easy;
import test.ListNode;


public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        /**
         * 循环实现(不使用虚拟头结点）
         */
//        while(head != null && head.val == val) {
//            head = head.next;
//        }
//
//        if(head == null) {
//            return null;
//        }
//
//        ListNode prev = head;
//        while (prev.next != null) {
//            if (prev.next.val == val) {
//                prev.next = prev.next.next;
//            } else {
//                prev = prev.next;
//            }
//        }
//
//        return head;
        /**
         * 循环实现(不使用虚拟头结点） 结束
         */

        /**
         * 循环实现(使用虚拟头结点）
         */
//        ListNode dummyHead = new ListNode(-1);
//        dummyHead.next = head;
//
//        ListNode prev = dummyHead;
//        while(prev.next != null) {
//            if(prev.next.val == val) {
//                prev.next = prev.next.next;
//            }else{
//                prev = prev.next;
//            }
//        }

//        return dummyHead.next;
        /**
         * 循环实现(使用虚拟头结点） 结束
         */

        /**
         * 递归实现
         */

        //递归终止条件
        if(head == null) {
            return null;
        }

        //基本问题
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next:head;

        /**
         * 递归实现 结束
         */

    }

    public static void main(String[] args) {
        int[] nums = {6, 1, 2, 6, 3, 4, 5, 6};
        ListNode node = new ListNode(nums);
        System.out.println(node);
        //new RemoveLinkedListElements().removeElements(node, 6);
        node = new RemoveLinkedListElements().removeElements(node, 6);
        System.out.println(node);
    }
}
