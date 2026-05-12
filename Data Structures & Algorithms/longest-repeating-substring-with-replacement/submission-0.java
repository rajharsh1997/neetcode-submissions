class Solution {
    public int characterReplacement(String s, int k) {
     Map<Character, Integer> windowMap = new HashMap<>();
     int left = 0;
     int maxFreq = 0;
     int maxLength = 0;

     for (int right = 0; right<s.length(); right++) {
        char ch = s.charAt(right);
        windowMap.put(ch, windowMap.getOrDefault(ch,0)+1);
        maxFreq = Math.max(maxFreq,windowMap.get(ch));
        while ((right-left+1)- maxFreq>k){
            char charLeft = s.charAt(left);
            //Deduct frequency
            windowMap.put(charLeft, windowMap.get(charLeft)-1);
            left++;
        }

        maxLength = Math.max(maxLength,(right-left+1));
     }
     return maxLength;
    }
}
