
class Solution {

    public void inOrder(TreeNode node, List<Integer> in){
        if(node == null){
            return;
        }

        inOrder(node.left,in);
        in.add(node.val);
        inOrder(node.right,in);

    }
    public TreeNode balanceBSTHelper(List<Integer> in, int start, int end){
        if(start>end){
            return null;
        }

        int mid = start + (end-start)/2;

        TreeNode node = new TreeNode(in.get(mid));

        node.left = balanceBSTHelper(in, start,mid-1);
        node.right = balanceBSTHelper(in, mid+1,end);

        return node;
    }
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> in = new ArrayList<>();

        inOrder(root,in);

        return balanceBSTHelper(in,0,in.size()-1);
     }
}