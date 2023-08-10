
class Solution {
    public String frequencySort(String s) {
        
        Map<Character, Integer> freqMap = new HashMap<>();

        int maxFreq = 0;
        for(int i=0;i<s.length();i++){
            freqMap.put(s.charAt(i),freqMap.getOrDefault(s.charAt(i),0)+1);
            if(freqMap.get(s.charAt(i))>maxFreq){
                maxFreq = freqMap.get(s.charAt(i));
            }
        }


        List<Character> freq[] = new ArrayList[maxFreq+1];


        for(Map.Entry<Character, Integer> entry: freqMap.entrySet()){
            if(freq[entry.getValue()]==null){
                freq[entry.getValue()] = new ArrayList<>();
            }

            freq[entry.getValue()].add(entry.getKey());
        }

        StringBuilder sb = new StringBuilder();

        for(int i=maxFreq;i>0;i--){
            
            List<Character> chList = freq[i];

            if(chList!=null){
                int j=chList.size()-1;
                
                while(j>=0){
                    int tempFreq = i;
                    while(tempFreq>0){
                        sb.append(chList.get(j));
                        tempFreq--;
                    }
                    
                    j--;
                }
            }
        }

        return sb.toString();

    }
}