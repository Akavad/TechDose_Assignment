class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int l =0;
        int r = 0;
        int max = 0;
        int freq[] = new int[128];

        for(int i=0;i<n;i++){
            /*if(!Character.isLetter(s.charAt(i))){
                continue;
            }*/
            freq[s.charAt(i)]++;

            if(freq[s.charAt(i)]>1){
                r = i-1;
                 int size = r-l+1;
                 if(size>max){
                    max = size;
                }
                while(freq[s.charAt(i)]>1){
                     freq[s.charAt(l)]--;
                     l++;
                }
            }else if(i==n-1){
                r = n-1;
                int size = r-l+1;
                if(size>max){
                    max = size;
                }
            }
        }
        return max;
        
    }
}