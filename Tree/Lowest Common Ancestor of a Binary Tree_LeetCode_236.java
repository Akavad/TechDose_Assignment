
class Solution {

    public TreeNode lcaHelper(TreeNode node, TreeNode p, TreeNode q){

        if(node == null){
            return null;
        }
        else if(node.val == p.val || node.val == q.val){
            return node;
        }

        TreeNode left = lcaHelper(node.left,p,q);
        TreeNode right = lcaHelper(node.right,p,q);

        if(left!=null && right!=null){
            return node;
        }
        else if(left!=null){
            return left;
        }
        else{
            return right;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaHelper(root,p,q);
    }
}