class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        
        Stack<Integer> st = new Stack<>();

        int nextGrt[] = new int[nums2.length]; 

        for(int i=nums2.length-1; i>=0 ; i--){

            while(!st.isEmpty() && nums2[i]>nums2[st.peek()]){
                st.pop();
            }

            if(!st.isEmpty()){
                nextGrt[i] = nums2[st.peek()];
               // System.out.println("next="+nextGrt[i]);
            }
            else{
                nextGrt[i] = -1;
            }

            st.push(i);
        }

        int ans[] = new int[nums1.length];

        for(int i=0;i<nums1.length;i++){
            

            for(int j=0;j<nums2.length;j++){

                if(nums1[i] == nums2[j]){
                    ans[i] = nextGrt[j];
                }
            }

        }

        return ans;
    }
}