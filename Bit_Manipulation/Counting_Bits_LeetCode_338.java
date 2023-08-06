class Solution {
    public int[] countBits(int n) {
        int ans[]=new int[n+1];
        int i=1;
        while(i<=n){
            ans[i]=ans[i/2]+i%2;
            i++;
        }
        return ans;
    }
}