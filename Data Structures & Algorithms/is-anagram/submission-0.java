class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> freq = new HashMap<>();
        for (int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        for (int i=0; i<t.length(); i++){
            char ch = t.charAt(i);
            if (freq.get(ch)==null){
                return false;
            } else if (freq.get(ch)==1){
                freq.remove(ch);
            } else {
                freq.put(ch, freq.get(ch)-1);
            }
        }
        if (freq.size()==0){
            return true;
        } else {
            return false;
        }
    }
}
