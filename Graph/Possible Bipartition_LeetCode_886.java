class Solution {

    public boolean possibleBipartitionHelper(int node, ArrayList<Integer> adj[], int color[], int currColor){

        if(color[node] != 0){
            return color[node]==currColor;
        }

        color[node] = currColor;

        if(adj[node]!=null){
            for(int i=0;i<adj[node].size();i++){

            if(!possibleBipartitionHelper(adj[node].get(i),adj,color,-currColor)){
                return false;
            }
        }
        }
        

        return true;
    }
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        ArrayList<Integer> adj[] = new ArrayList[n+1];
        for(int i=0;i<dislikes.length;i++){
            if(adj[dislikes[i][0]]==null){
                adj[dislikes[i][0]] = new ArrayList<>();
            }
            adj[dislikes[i][0]].add(dislikes[i][1]);

            if(adj[dislikes[i][1]]==null){
                adj[dislikes[i][1]] = new ArrayList<>();
            }

             adj[dislikes[i][1]].add(dislikes[i][0]);
        }
        int color[] = new int[n+1];
        for(int i=1;i<=n;i++){

            if(color[i]==0 && !possibleBipartitionHelper(i,adj,color,1)){
                return false;
            }
        }

        return true;
    }
}