package algorithm_methods.depth_first_search;
//深度优先搜索

/***
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-deepest-leaves/
 */
class PracticeOne {
    //从下到上计算深度
    //题目所求为：深度最大且左右子树高度相等的节点
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        int l = findDeep(root.left);
        int r = findDeep(root.right);
        if (l == r) return root;
        if (l > r) return lcaDeepestLeaves(root.left);
        else return lcaDeepestLeaves(root.right);
    }
    public int findDeep(TreeNode root) {
        if (root == null) return 0;
        int l = findDeep(root.left);
        int r = findDeep(root.right);
        int deep = Math.max(l, r) + 1;
        return deep;
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}