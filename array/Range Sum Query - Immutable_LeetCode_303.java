class NumArray {
    
    int prefixSum[];
    public NumArray(int[] nums) {
        prefixSum = nums;
        for(int i=0;i<prefixSum.length;i++){
            if(i!=0){
               prefixSum[i]+=prefixSum[i-1];
            }
                     
        }
    }
    
    public int sumRange(int left, int right) {
        if(left==0){
            return prefixSum[right];
        }
        else{
            return prefixSum[right]-prefixSum[left-1];
        }
    }
}

