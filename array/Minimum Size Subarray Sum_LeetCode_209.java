class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int sum =0;
        int min=Integer.MAX_VALUE;
        int i=0;
        for(int j=0;j<n;j++){

            sum+=nums[j];

            while(sum>=target && i<=j){
                min = Math.min(j-i+1,min);
                sum-=nums[i];
                i++;
            }
            
        }
        return min == Integer.MAX_VALUE?0:min;
    }
}