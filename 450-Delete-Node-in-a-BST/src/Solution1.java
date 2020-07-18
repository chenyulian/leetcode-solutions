
public class Solution1 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    // 找到以node为根的树中的最小值
    private TreeNode findMin(TreeNode node) {
        if(node.left == null) {
            return node;
        }

        return findMin(node.left);
    }

    // 返回删除了以node为根的树中的最小值的新树的根
    private TreeNode delMin(TreeNode node) {
        if(node.left == null) {
            TreeNode rightNode = node.right;
            node.right = null;
           return rightNode;
        }

        node.left = delMin(node.left);
        return node;

    }
    // 返回删除掉指定元素之后的BST的根
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }

        if(key > root.val) {
            // 去右子树查找
            root.right = deleteNode(root.right, key);
            return root;
        }else if(key < root.val) {
            // 去左子树查找
            root.left = deleteNode(root.left, key);
            return root;
        }else{ // 找到了这个元素
            if(root.left == null) {
                // 这个元素的右子树不能丢掉
                TreeNode rightNode = root.right;
                root.right = null;
                return rightNode;
            }

            if(root.right == null) {
                TreeNode leftNode = root.left;
                root.left = null;
                return leftNode;
            }

            // 待删除元素的左右子树均不为Null
            // 需要找到一个节点successor用来替代该元素的位置
            // 1. 可以是比它大的最小元素 2. 也可以是比它小的最大元素
            // 以第1种情况为例，需要找到以该元素的right为根的树中的最小值
            // 然后把待删除元素的右子树（已删除successor的）、待删除元素的左子树接到successor上
            TreeNode successor = findMin(root.right);
            successor.right = delMin(root.right);
            successor.left = root.left;
            // 删除元素
            root.left = root.right = null;
            return successor;
        }
    }


}
