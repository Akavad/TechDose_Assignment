
 class NodeInfo{
     int dia;
     int ht;

     NodeInfo(int dia, int ht){
         this.dia = dia;
         this.ht = ht;
     }

 }
class Solution {
  
    public NodeInfo diameterBTHelper(TreeNode node){

        if(node == null){
            return new NodeInfo(-1,-1);
        }

        NodeInfo left = diameterBTHelper(node.left);
        NodeInfo right = diameterBTHelper(node.right);
 
       return new NodeInfo(Math.max(left.ht+right.ht+2,Math.max(left.dia,right.dia)),Math.max(left.ht,right.ht)+1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        return diameterBTHelper(root).dia;
        
    }
}