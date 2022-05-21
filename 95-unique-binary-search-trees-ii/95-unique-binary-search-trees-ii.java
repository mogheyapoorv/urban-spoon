/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
 public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<TreeNode>();
        }
        return generate_trees(1, n);
    }

    public LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> all_trees = new LinkedList<>();
        if (start > end) {
            all_trees.add(null);
            return all_trees;
        }

        for (int i = start; i <= end; i++) {
            LinkedList<TreeNode> leftTree = generate_trees(start, i - 1);
            LinkedList<TreeNode> rightTree = generate_trees(i + 1, end);

            for (TreeNode l : leftTree) {
                for (TreeNode r : rightTree) {
                    TreeNode currentNode = new TreeNode(i);
                    currentNode.left = l;
                    currentNode.right = r;
                    all_trees.add(currentNode);
                }
            }
        }
        return all_trees;
    }
}