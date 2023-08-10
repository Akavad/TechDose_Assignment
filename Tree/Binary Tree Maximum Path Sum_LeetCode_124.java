
class Solution {

    int ans;
    public int maxPathSumHelper(TreeNode node){

        if(node == null){
            return 0;
        }

        int left = maxPathSumHelper(node.left);
        int right = maxPathSumHelper(node.right);

        int maxStraightPath = Math.max(Math.max(left,right)+node.val,node.val);

        int maxPathIncludedCurrentNode = Math.max(maxStraightPath, left+right+node.val);
        
        
        ans =Math.max(maxPathIncludedCurrentNode,ans);

        return maxStraightPath;
    }
    public int maxPathSum(TreeNode root) {
        ans = Integer.MIN_VALUE;
        maxPathSumHelper(root);
        return ans;
    }
}