
class Solution {
    
    public void invert(TreeNode root){
        if(root == null){
            return;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invert(root.right);
        invert(root.left);
    }
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
        
    }
}