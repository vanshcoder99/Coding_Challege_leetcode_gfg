class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            int left = target - nums[i];
            if(mpp.containsKey(left)){
                return new int[]{mpp.get(left),i};
            }
            mpp.put(nums[i],i);
        }
        return new int[]{-1,-1};
    }
}