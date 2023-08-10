class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            String s = strs[i];

            int freq[] = new int[26];
            for(int j=0;j<s.length();j++){
                freq[s.charAt(j) - 'a']++;
                
            }

            String key = "";
            
            for(int k=0;k<26;k++){
                key+=freq[k]+"-";
            }
           
            
            if(map.containsKey(key)){
                List<String> temp = map.get(key);
                temp.add(s);
                map.put(key,temp);
            }
            else{
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key,list);
            }
        }
        
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()){
            List<String> temp = entry.getValue();
            ans.add(temp);
        }


        return ans;
    }
}