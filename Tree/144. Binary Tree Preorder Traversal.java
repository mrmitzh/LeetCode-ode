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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }
    public void recursive(TreeNode node, List<Integer> res) {
        if(node == null) return;
        res.add(node.val);
        recursive(node.left, res);
        recursive(node.right, res);
    }
    
    public List<Integer> iterative(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.addFirst(root);
        TreeNode curr = null;
        while(!stack.isEmpty()) {
            curr = stack.removeFirst();
            res.add(curr.val);
            if(curr.right != null) stack.addFirst(curr.right);
            if(curr.left != null) stack.addFirst(curr.left);
            
        }
        return res;
    }
    
    public List<Integer> morris(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        TreeNode prev = null;
        while (root != null) {
            if (root.left == null) {
                res.add(root.val);
                root = root.right;
            } else {
                prev = root.left;
                while (prev.right != null && prev.right != root){
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = root;
                    res.add(root.val);
                    root = root.left;
                } else {
                    prev.right = null;
                    root = root.right;
                }
            }
        }
        return res;
    }
}
