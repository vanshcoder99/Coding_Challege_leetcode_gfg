class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        int ans = Integer.MIN_VALUE,diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int j = i+1, k = n-1;
            while(j<k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return target;
                else if(sum<target){
                    if(diff == Integer.MAX_VALUE || diff>(target-sum)){
                        ans = sum;
                        diff = target-sum;
                    }
                    j++;
                }
                else{
                    if(diff == Integer.MAX_VALUE || diff>(sum-target)){
                        ans = sum;
                        diff = sum-target;
                    }
                    k--;
                }
            }
        }
        return ans;
    }
}