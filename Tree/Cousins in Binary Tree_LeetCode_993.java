
 class NodeInfo{
     int level;
     int parent;
     boolean isCousin;
     NodeInfo(int level, int parent){
         this.level = level;
         this.parent = parent;
     }
 }
class Solution {

    public NodeInfo isCousinsHelper(TreeNode node, int x, int y, int parent, int level){

        if(node==null){
            return null;
        }

        if(node.val == x || node.val == y){
            return new NodeInfo(level, parent);
        }

        NodeInfo left= isCousinsHelper(node.left,x,y,node.val,level+1);
        NodeInfo right= isCousinsHelper(node.right,x,y,node.val,level+1);

        if(left!=null && right!=null && (left.level == right.level) && (left.parent!=right.parent)){
            NodeInfo temp = new NodeInfo(level,parent);
            temp.isCousin = true;
            return temp;
        }
        else if(left !=null){
            return left;
        }
        else if(right!=null){
            return right;
        }
        else{
            return null;
        }

    }
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root!=null){
             return isCousinsHelper(root,x,y,-1,0).isCousin;
        }
        else{
            return false;
        }
    }
}