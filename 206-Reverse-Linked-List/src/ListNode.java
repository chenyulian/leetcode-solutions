public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    // 使用数组初始化链表，测试用
    public ListNode(int[] nums) {
        if(nums == null || nums.length == 0) {
            throw new IllegalArgumentException("array cannot be empty");
        }
        this.val = nums[0];
        ListNode node = this;
        for(int i = 1; i < nums.length; i ++) {
            node.next = new ListNode(nums[i]);
            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();

        res.append("ListNode: ");
        ListNode cur = this;
        while(cur != null) {
            res.append(cur.val);
            res.append("->");
            cur = cur.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
