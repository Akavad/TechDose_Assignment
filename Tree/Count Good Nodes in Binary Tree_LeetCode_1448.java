
class Solution {
    int ans;
    public void goodNodesHelper(TreeNode node, int max){

        if(node == null){
            return;
        }

        if(node.val>=max){
            ans++;
            max = node.val;
        }

        goodNodesHelper(node.left,max);
        goodNodesHelper(node.right,max);

    }
    public int goodNodes(TreeNode root) {
        ans=0;
        goodNodesHelper(root,root.val);
        return ans;
    }
}