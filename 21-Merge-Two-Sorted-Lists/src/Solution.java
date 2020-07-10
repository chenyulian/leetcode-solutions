public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode dummyHead = new ListNode(-1);
        ListNode ret = dummyHead;

        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                ret.next = l1;
                l1 = l1.next;
            }else {
                ret.next = l2;
                l2 = l2.next;
            }
            ret = ret.next;
        }

        ret.next = l1 == null ? l2 : l1;

        return dummyHead.next;
    }

    public static void main(String[] args) {
        int[] num1 = {1, 2, 4};
        int[] num2 = {1, 3, 4};
        System.out.println(new Solution().mergeTwoLists(new ListNode(num1), new ListNode(num2)));
    }
}
