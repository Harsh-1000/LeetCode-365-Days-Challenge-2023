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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        
        dfs(p,l1);
         
        dfs(q,l2);
        
        return l1.equals(l2);
        
    }
    
    private void dfs(TreeNode root, List list){
        
        if(root==null)
            return;
        
        list.add(root.val);
        
        if(root.left==null && root.right!=null)
            list.add(null);
        else
            dfs(root.left,list);
        
        if(root.right==null && root.left!=null)
            list.add(null);
        else
            dfs(root.right,list);
    }
    
}