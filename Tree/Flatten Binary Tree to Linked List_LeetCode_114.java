
class Solution {
    TreeNode prev;

    public void flattenHelper(TreeNode node){

        if(node==null){
            return;
        }
        
        if(prev!=null){
            prev.left = null;
            prev.right = node;
        }

        TreeNode right = node.right;
        prev = node;      
        flattenHelper(node.left);
        flattenHelper(right);

    }
    public void flatten(TreeNode root) {
    prev = null;
     flattenHelper(root);
        
    }
}