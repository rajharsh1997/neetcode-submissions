class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> compMap = new HashMap<>();
        for (int i=0;i<nums.length;i++){
            Integer compIndex = compMap.get(nums[i]);
            if (compIndex != null ){
                return new int[]{compIndex,i};
            }
            compMap.put(target-nums[i],i);            
        }
        return null;
    }
}
