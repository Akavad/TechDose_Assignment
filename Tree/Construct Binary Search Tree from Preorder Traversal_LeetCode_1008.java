
class Solution {
   
    int i;
    public void bstFromPreorderHelper(int[] pre, TreeNode currNode, int min, int max){
        
       if(i==pre.length || pre[i]<min || pre[i]>max){
           return;
       }

        if(pre[i]<currNode.val){
            currNode.left = new TreeNode(pre[i]);
            //System.out.println(currNode.val+" "+pre[i]);
            i++;
            bstFromPreorderHelper(pre,currNode.left,min,currNode.val);
        }

        if(i==pre.length){
           return;
        }
        if(pre[i]>currNode.val && pre[i]<max){
            currNode.right = new TreeNode(pre[i]);
            i++;
            bstFromPreorderHelper(pre,currNode.right,currNode.val,max);
        }
       return;
       
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        i=1;
        TreeNode root = new TreeNode(preorder[0]);
        bstFromPreorderHelper(preorder,root,Integer.MIN_VALUE,Integer.MAX_VALUE);
        return root;
    }
}