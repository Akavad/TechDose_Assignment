class Solution {
    public int singleNumber(int[] nums) {
        int ans =0;
        int base = 1;
        for(int i=0;i<32;i++){

            int sum=0;
            for(int j=0;j<nums.length;j++){
                sum+=(nums[j]>>i & 1);
            }

            //System.out.println("ans="+ans);
            // System.out.println("sum="+sum);
            ans+= (sum%3)*base;
            base = base *2;
        }

        return ans;
    }
}