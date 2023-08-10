class Solution {

    public int largestRectangleInHistogram(int a[]){
        int n = a.length;

        int smallerRight[] = new int[n];
        int smallerLeft[]  = new int[n];

        Stack<Integer> st = new Stack<>();

        for(int i=n-1;i>=0;i--){

            while(!st.isEmpty() && a[i]<=a[st.peek()]){
                st.pop();
            }

            if(!st.isEmpty()){
                smallerRight[i] = st.peek()-1;
            }
            else{
                smallerRight[i]=n-1;
            }

            st.push(i);
        }

        while(!st.isEmpty()){
            st.pop();
        }

        for(int i=0;i<n;i++){

            while(!st.isEmpty() && a[i]<=a[st.peek()]){
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

        int ans = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){

            int area = (smallerRight[i]-smallerLeft[i]+1)*a[i];

            if(area>ans){
                ans = area;
            }

        }

        return ans;

    }

    public int maximalRectangle(char[][] matrix) {
        int ans = Integer.MIN_VALUE;

        int a[] = new int[matrix[0].length];

        for(int i=0;i<matrix.length;i++){

            for(int j=0;j<matrix[0].length;j++){

                a[j]+=(matrix[i][j] == '1' ? matrix[i][j]-'0' : -a[j]);
            }

            int area = largestRectangleInHistogram(a);
            if(area>ans){
                ans = area;
            }
        }

        return ans;
    }
}