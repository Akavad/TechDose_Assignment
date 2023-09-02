class Solution {

   int dsuf[];
   int rank[];
   int noOfComponents;
   
   public int numberOfConnectedComponents(int n, List<Integer> arr[]){
   
      dsuf= new int[n+1];
      rank= new int[n+1];
	  noOfComponent = n;
         for(int i=1;i<=n;i++){
            dsuf[i]=i;
         }
          for(int i=1;i<=n;i++){

            if(arr[i]!=null){
                for(int j=0;j<arr[i].size();j++){

                    union(i,arr[i].get(j));
                    
                }
                
            }
        }
        
		
       return noOfComponents;
   
   }
   
   public int find(int u){

        if(dsuf[u]==u){
            return u;
        }

        dsuf[u]=find(dsuf[u]);
        return dsuf[u];
   }
   
    public void union(int u, int v){

        int uParent = find(u);
        int vParent = find(v);

        if(uParent!=vParent){
            noOfComponents--;
            if(rank[uParent]<rank[vParent]){
                dsuf[uParent]=vParent;
            }
            else if(rank[uParent]>rank[vParent]){
                dsuf[vParent]=uParent;
            }
            else{
                dsuf[uParent]=vParent;
                rank[vParent]++;
            }
        }

    }

}