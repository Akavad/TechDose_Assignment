
class Solution {

    public void findParent(TreeNode node, Map<TreeNode,TreeNode> map){
        if(node==null){
            return;
        }

        if(node.left!=null){
            map.put(node.left,node);
        }

        if(node.right!=null){
            map.put(node.right,node);
        }

        findParent(node.left,map);
        findParent(node.right,map);
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();

        Map<TreeNode,TreeNode> map = new HashMap<>();

        findParent(root,map);

        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        Set<TreeNode> vis = new HashSet<>();
        while(!q.isEmpty()){

            int size = q.size();

            for(int i=0;i<size;i++){

                TreeNode node = q.poll();
                vis.add(node);

                if(k==0){
                    ans.add(node.val);
                }
                if(node.left!=null && !vis.contains(node.left)){
                    q.add(node.left);
                }

                if(node.right!=null && !vis.contains(node.right)){
                    q.add(node.right);
                }

                if(map.get(node)!=null && !vis.contains(map.get(node))){
                    q.add(map.get(node));
                }

            }
            k--;
            if(k<0){
                break;
            }
        }
        return ans;
    }
}