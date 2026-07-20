class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums){
            if (numSet.add(num) == false){
                return true;
            }
        }
        return false;
    }
}