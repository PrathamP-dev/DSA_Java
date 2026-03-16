// LC 987 Vertical Order Traversal of a Binary Tree

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
    class Node {
        int col, row, val;
        Node(int c, int r, int v) {
            col = c;
            row = r;
            val = v;
        }
    }

    List<Node> list = new ArrayList<>();

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        dfs(root, 0, 0);

        Collections.sort(list, (a, b) -> {
            if (a.col != b.col) return a.col - b.col;
            if (a.row != b.row) return a.row - b.row;
            return a.val - b.val;
        });

        List<List<Integer>> res = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;

        for (Node node : list) {
            if (node.col != prevCol) {
                res.add(new ArrayList<>());
                prevCol = node.col;
            }
            res.get(res.size() - 1).add(node.val);
        }

        return res;
    }

    private void dfs(TreeNode root, int row, int col) {
        if (root == null) return;

        list.add(new Node(col, row, root.val));

        dfs(root.left, row + 1, col - 1);
        dfs(root.right, row + 1, col + 1);    
    }
}
