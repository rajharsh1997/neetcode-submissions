class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> numsMap = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            Integer compIndex = numsMap.get(nums[i]);
            if (compIndex != null){
                return new int[]{compIndex,i};
            }
            numsMap.put(target-nums[i],i);
        }
        return null;
    }
}
