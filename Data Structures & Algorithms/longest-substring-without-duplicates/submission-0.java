class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        int maxLength = 0;
        Set<Character> windowSet = new HashSet<>();
        for (int right = 0; right < s.length(); right++){
            char rightChar = s.charAt(right);
            while (windowSet.contains(rightChar)){
                windowSet.remove(s.charAt(left));
                left++;
            }
            windowSet.add(rightChar);
            maxLength = Math.max(maxLength,right-left+1);
        }
        return maxLength;
    }
}
