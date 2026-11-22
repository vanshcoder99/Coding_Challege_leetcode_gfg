class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = nums[i];
            int left = target - val;
            if(mpp.containsKey(left)) return new int[]{mpp.get(left),i};
            mpp.put(val,i);
        }
        return new int[]{-1,-1};
    }
}