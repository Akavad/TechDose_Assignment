class Solution {
    public int maxProfit(int[] a) {
        int n=a.length;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int minIndex = -1;
        
        for(int i=0;i<n;i++){
            if(i==0 && i+1<n && a[i]<a[i+1] && a[i]<min){
                min = a[i];
                minIndex = i;

            }
            else if(i==n-1 && (i-1>=0 && a[i]>a[i-1]) && a[i]>max){
                max = a[i];
            }
            else if((i-1>=0 && i+1<n) && a[i]<=a[i-1] && a[i]<=a[i+1] && a[i]<min){
                min = a[i];
                minIndex = i;
            }
            else if((i-1>=0 && i+1<n) && a[i]>=a[i-1] && a[i]>=a[i+1] && a[i]>max && i>minIndex){
                max = a[i];
            }
        }

        System.out.println("min="+min+"max="+max);
        if(min != Integer.MAX_VALUE && max != Integer.MIN_VALUE){
            return max-min;
        }else{
            return 0;
        }
    }
}