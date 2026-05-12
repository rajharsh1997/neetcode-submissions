class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        if (strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map <String, List<String>> anagramGMap = new HashMap<>();

        for (String word : strs){
            int [] charFrequency = new int [26];

            for (int i = 0; i < word.length(); i++){
                charFrequency[word.charAt(i)-'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++ ){
                sb.append("#");
                sb.append(charFrequency[i]);
            }

            String frequencyKey = sb.toString();

            if (!anagramGMap.containsKey(frequencyKey)){
                anagramGMap.put(frequencyKey, new ArrayList<>());
            }

            anagramGMap.get(frequencyKey).add(word);
        }

        return new ArrayList<>(anagramGMap.values());

    }
}
