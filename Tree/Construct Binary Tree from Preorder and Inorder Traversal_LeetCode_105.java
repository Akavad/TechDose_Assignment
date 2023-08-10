
class Solution {
    int preIndex;
    public TreeNode buildTreeHelper(int []pre, int in[], int start, int end, Map<Integer, Integer> map){

        if(start>end){
            return null;
        }
        
         TreeNode node = new TreeNode(pre[preIndex]);
        preIndex++;

        if(start == end){
            return node;
        }

        int inIndex = map.get(node.val);
        

       

        node.left = buildTreeHelper(pre, in, start,inIndex-1,map);
        node.right = buildTreeHelper(pre, in, inIndex+1,end,map);

        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preIndex=0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return buildTreeHelper(preorder,inorder, 0, inorder.length-1,map);
    }
}