
class Solution {

    public boolean isValidBSTHelper(TreeNode root , long max , long min){

        if(root == null){
            return true;
        }

        if(root.val>=max || root.val<=min){
            return false;
        }
        return isValidBSTHelper(root.left, root.val, min) && isValidBSTHelper(root.right, max , root.val);
    }
    public boolean isValidBST(TreeNode root) {
        return isValidBSTHelper(root, Long.MAX_VALUE, Long.MIN_VALUE) ;
    }
}