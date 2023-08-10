class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int max = 0;

        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                map.put(nums[i],map.get(nums[i])+1);
            }
            else{
                map.put(nums[i],1);
            }
            if(map.get(nums[i])>max){
                max = map.get(nums[i]);
            }

        }


        List<Integer> freq[] = new ArrayList[max+1];

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            if(freq[entry.getValue()]==null){
                freq[entry.getValue()]= new ArrayList<>();
            }
            freq[entry.getValue()].add(entry.getKey());
        }

       int ans[] = new int[k];
       int j=0;
        for(int i=max;i>0;i--){
            if(k==0){
                break;
            }
            if(freq[i]!=null){
                int index=0;
                while(index<freq[i].size()){
                    ans[j]=freq[i].get(index);
                    k--;
                    j++;
                    index++;
                }
               
                
            }
        }

        return ans;
    }
}