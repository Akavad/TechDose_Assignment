class Solution {
    
    public boolean isCycle(int node, int color[], ArrayList<Integer> adj[]){

        color[node]=1;
        
        if(adj[node]!=null){
            for(int i=0;i<adj[node].size();i++){

            if(color[adj[node].get(i)]==0 && isCycle(adj[node].get(i),color,adj)){
                return true;
            }
            else if(color[adj[node].get(i)]==1){
                return true;
            }
           }
        }
        

        color[node]=2;
        return false;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<Integer> adj[] = new ArrayList[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            if(adj[prerequisites[i][1]]==null){
                adj[prerequisites[i][1]] = new ArrayList<>();
            }
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }

        int color[] = new int[numCourses];
        for(int i=0;i<numCourses;i++){

            if(color[i]==0){
                if(isCycle(i,color,adj)){
                    return false;
                }
            }
        }

        return true;
    }
}