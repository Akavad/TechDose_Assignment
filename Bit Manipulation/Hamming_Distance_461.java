class Solution {
    public int hammingDistance(int x, int y) {
        int i=0;
        int count=0;
        while(i<32){
            if(((x>>i) & 1) != ((y>>i)&1)){
                count++;
            }
            i++;
        }
        return count;
    }
}