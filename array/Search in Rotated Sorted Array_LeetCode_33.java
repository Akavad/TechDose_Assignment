class Solution {

    public int searchInRotated(int arr[], int start, int end, int target){

       if(start<=end){

           int mid = start+(end-start)/2;
           //System.out.println(arr[mid]);
           if(arr[mid]==target){
               return mid;
           }

           if(arr[mid]>=arr[start]){

               if(target<arr[mid] && target>=arr[start]){
                    return searchInRotated(arr,start,mid-1,target);
               }
               else{
                    return searchInRotated(arr,mid+1,end,target);
               }
              
           }
           else{

               if(target>arr[mid]&& target<=arr[end]){
                   return searchInRotated(arr,mid+1,end,target);
               }
               else{
                    return searchInRotated(arr,start,mid-1,target);
               }
           }


       }

       return -1;
    }
    public int search(int[] nums, int target) {
        return searchInRotated(nums,0,nums.length-1,target);
    }
}