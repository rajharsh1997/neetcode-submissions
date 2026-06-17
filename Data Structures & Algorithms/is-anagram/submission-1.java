class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()){
            return false;
        }

        Map <Character,Integer> freqMap = new HashMap<>();
        for (char ch : s.toCharArray()){
            freqMap.put(ch,freqMap.getOrDefault(ch,0)+1);
        }
        System.out.println(freqMap);

        for (char ch : t.toCharArray()){
            if (freqMap.containsKey(ch) == false){
                return false;
            }
            if (freqMap.get(ch)==0){
                return false;
            }
            freqMap.put(ch , freqMap.get(ch)-1);
        }
        return true;
    }
}
