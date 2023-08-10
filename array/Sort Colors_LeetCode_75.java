class Solution {

    public void swap(int a[], int i, int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    
    }
    public void sortColors(int[] nums) {
        int l=0;
        int m=0;
        int h= nums.length-1;

        while(m<=h){
            if(nums[m]==0){
                swap(nums, m, l);
                l++;
                m++;
            }
            else if(nums[m]==1){
                m++;
            }
            else if(nums[m]==2){
                swap(nums, m,h);
                h--;
            }


        }
    }
}