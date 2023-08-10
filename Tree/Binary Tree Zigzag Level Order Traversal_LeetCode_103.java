
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Deque<TreeNode> q = new LinkedList<>();
        boolean isReverse = false;

        if(root != null){
            q.add(root);
        }


        while(!q.isEmpty()){

            int size = q.size();

            List<Integer> list = new ArrayList<>();
            for(int i=0;i<size;i++){

                TreeNode node= isReverse?q.pollLast():q.pollFirst();
                list.add(node.val);

                if(isReverse){
                    if(node.right!=null){
                        q.addFirst(node.right);
                    }
                    if(node.left!=null){
                        q.addFirst(node.left);
                    }
                }
                else{
                    if(node.left!=null){
                        q.addLast(node.left);
                    }
                    if(node.right!=null){
                        q.addLast(node.right);
                    }
                }

            }
            ans.add(list);
            isReverse = !isReverse;
        }
        return ans;
    }
}