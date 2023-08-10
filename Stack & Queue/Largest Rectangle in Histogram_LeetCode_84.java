class Solution {
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer>  st = new Stack<>();

        int n = heights.length;
        int smallerLeft[] = new int[n];
        int smallerRight[] = new int[n];

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }

            if(!st.isEmpty()){
                smallerLeft[i] = st.peek()+1;
            }
            else{
                smallerLeft[i] = 0;
            }
            
            st.push(i);

        }

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i = n-1;i>=0;i--){

            while(!st.isEmpty() && heights[i]<=heights[st.peek()]){
                st.pop();
            }

            if(!st.isEmpty()){
                smallerRight[i] = st.peek()-1;
            }
            else{
                smallerRight[i] = n-1;
            }
           
            st.push(i);
        }

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            int area = (smallerRight[i]-smallerLeft[i]+1)*heights[i];

            if(area>ans){
                ans = area;
            }

        }

        return ans;

    }
}