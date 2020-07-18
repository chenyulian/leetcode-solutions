public class Solution {
    public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
    }

    long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {

        if(root == null) return true;

        // 先访问左子树，再访问当前节点，再访问右子树
        if(!isValidBST(root.left)) {
            return false;
        }
        // 如果当前节点小于中序遍历的前一个节点，说明不满足BST，返回false；否则继续遍历
        if(root.val <= pre) {
            return false;
        }
        pre = root.val;

        return isValidBST(root.right);
    }


}
