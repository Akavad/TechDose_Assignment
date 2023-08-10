class Solution {
    int ans;
    public int partition(int a[], int start, int end){

        int p=a[end];

        int i=start-1;

        for(int j=start;j<=end-1;j++){

            if(a[j]<p){
                i++;

                int temp = a[i];
                a[i]=a[j];
                a[j]=temp;
            }
        }

        int temp2=a[i+1];
        a[i+1]=a[end];
        a[end]=temp2;

        return i+1;

    }

    public void quickSort(int a[], int start, int end, int k){

        if(start<end){

            int p = partition(a, start, end);
         //System.out.println(p+" "+k+" "+a[end]);
            if(p == k){
                //System.out.println(a[p]);
                ans = a[p];
            }
            else if(k > p){
                quickSort(a, p+1, end, k);
                 
            }
            else {
                quickSort(a, start, p-1, k);
            }
            
        }
               if(end == k){
            ans = a[end];
            
        }

    }
    public int findKthLargest(int[] nums, int k) {
       /* if(nums.length==1 && k==1){
            return nums[0];
        }*/
        quickSort(nums, 0, nums.length-1, nums.length-k);
        return ans;
    }
}