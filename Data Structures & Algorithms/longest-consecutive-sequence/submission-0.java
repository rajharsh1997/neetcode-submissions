class Solution {
    public int longestConsecutive(int[] nums) {
        
        Set<Integer> numSet = new HashSet<>();

        for (int num : nums){
            numSet.add(num);
        }
        int longest = 0;
        for (int n : numSet){
            if (!numSet.contains(n-1)){
                int current = n;
                int length = 1;
                while (numSet.contains(current+1)){
                    current++;
                    length++;
                }
                longest = Math.max(longest,length);
            }
        }
        return longest;
    }
}
