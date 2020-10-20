package newcode.tree;

import node.TreeNode;

/**
 * @author luzc
 * @date 2020/10/20 13:46
 * @desc 二叉查找树的第 K 个结点
 */
public class Tree13 {
    private TreeNode ret;
    private int cnt = 0;

    public TreeNode KthNode(TreeNode pRoot, int k) {
        inOrder(pRoot, k);
        return ret;
    }

    private void inOrder(TreeNode root, int k) {
        if (root == null || cnt >= k)
            return;
        inOrder(root.left, k);
        cnt++;
        if (cnt == k)
            ret = root;
        inOrder(root.right, k);
    }
}
