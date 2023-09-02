//method 1 using topological sorting
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        ArrayList<Integer> adj[] = new ArrayList[numCourses];
        int indegree[] = new int[numCourses];

        for(int i=0;i<prerequisites.length;i++){
            if(adj[prerequisites[i][1]]==null){
                adj[prerequisites[i][1]] = new ArrayList<>();
            }
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
            indegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
         
        int ans[] = new int[numCourses];
        int noOfNodes = 0;
        int k=0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans[k]=node;

            if(adj[node]!=null){
                for(int i=0;i<adj[node].size();i++){
                indegree[adj[node].get(i)]--;
                if(indegree[adj[node].get(i)]==0){
                    q.add(adj[node].get(i));

                }
              }
            }
            
            noOfNodes++;
            k++;
        }

        if(noOfNodes!=numCourses){
            return new int[0];
        }

        return ans;
    }
}


//method 2 using dfs
class Solution {
    boolean isCyclic;
    LinkedList<Integer> adj[];
    Stack<Integer> st;
    public void dfs(int node, int vis[], int colored[]){
        if(isCyclic){
            return;
        }
        if(colored[node]==1){
            isCyclic = true;
            return;
        }
        if(vis[node]==1){
            return;
        }
        vis[node]=1;
        colored[node]=1;
        for(int i=0;i<adj[node].size();i++){
             dfs(adj[node].get(i),vis, colored);
        }
        colored[node]=0;
        st.push(node);
        
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        adj = new LinkedList[numCourses];
        st = new Stack<>();
        isCyclic = false;
        for(int i=0;i<adj.length;i++){
            adj[i]=new LinkedList<>();
        }
        
        for(int i=0;i<prerequisites.length;i++){
            adj[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        int vis[] = new int[numCourses];
         int colored[] = new int[numCourses];
        for(int i=0;i<vis.length;i++){
            if(vis[i]!=1){
                dfs(i,vis,colored);
            }
        }
        if(isCyclic){
            return new int[0];
        }
        
        int ans[] = new int[st.size()];
        
        int i=0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }
}