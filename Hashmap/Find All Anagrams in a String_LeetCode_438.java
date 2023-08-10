class Solution {
    public boolean isAnagrams(int freq1[], int freq2[]){

        for(int i=0;i<26;i++){
            if(freq1[i]!=freq2[i]){
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans = new ArrayList<>();

        int freq1[] = new int[26];
        int freq2[] = new int[26];

        for(int i=0;i<p.length();i++){
            freq1[p.charAt(i)-'a']++;
        }

        int n = s.length();
        int m = p.length();
        
        if(m>n){
            return ans;
        }
        for(int i=0;i<m;i++){
            freq2[s.charAt(i)-'a']++;
        }

        if(isAnagrams(freq1,freq2)){
            ans.add(0);
        }

        for(int i=1;i<n-m+1;i++){

            freq2[s.charAt(i+m-1)-'a']++;
            freq2[s.charAt(i-1)-'a']--;

            if(isAnagrams(freq1,freq2)){
                ans.add(i);
            }
        }
        return ans;
                
    }
}