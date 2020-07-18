import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution1 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new LinkedList<>();
        }

        List<List<Integer>> res = new LinkedList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new LinkedList<>();

            for(int i = 0; i < size; i ++) {
                TreeNode cur = queue.remove();
                temp.add(cur.val);
                if(cur.left != null) {
                    queue.add(cur.left);
                }

                if(cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(temp);
        }

        return res;
    }

}
