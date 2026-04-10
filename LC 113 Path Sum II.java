// LC 113 Path Sum II

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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), result);
        return result;
    }

    private void dfs(TreeNode node, int remaining, List<Integer> path, List<List<Integer>> result) {
        if (node == null) return;

        path.add(node.val);

        // Check if leaf and sum matches
        if (node.left == null && node.right == null && remaining == node.val) {
            result.add(new ArrayList<>(path));
        } else {
            dfs(node.left, remaining - node.val, path, result);
            dfs(node.right, remaining - node.val, path, result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}
