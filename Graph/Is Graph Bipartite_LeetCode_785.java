class Solution {

    public boolean isBipartiteHelper(int[][] graph, int color[], int node, int currColor){
        
        if(color[node]!=-1){
            return color[node] == currColor;
        }
        
        color[node] =  currColor;
        
        for(int i=0;i<graph[node].length;i++){
           
            if(!isBipartiteHelper(graph,color,graph[node][i],1-currColor)){
               
                return false;
            }
            
        }
         return true;
    }
    
    public boolean isBipartite(int[][] graph) {
        
        int color[] = new int[graph.length];
        Arrays.fill(color,-1);
        int currColor = 0;
        for(int i=0;i<graph.length;i++){

            if(color[i]==-1){
                if(!isBipartiteHelper(graph,color,i,currColor)){
                    return false;
                }
            }
        }
        return true;
        
        
    }
}