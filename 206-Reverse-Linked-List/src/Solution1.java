public class Solution1 {

    // 循环解法
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while(cur != null) {
            ListNode temp = cur.next;
            // 反转
            cur.next = prev;
            // prev指针后移
            prev = cur;
            // cur指针后移
            cur = temp;
        }

        return prev;
    }

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 5, 4};
        System.out.println(new Solution1().reverseList(new ListNode(test)));
    }
}


