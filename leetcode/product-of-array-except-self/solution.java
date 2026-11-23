class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suf = new int[n];
        int prod1 = 1, prod2 = 1;
        for(int i=0;i<n;i++){
            prod2*=nums[n-i-1];
            suf[n-i-1] = prod2;
        }
        int[] ans = new int[n];
        for(int i=0;i<n;i++){
            ans[i] = prod1 * ((i!=n-1) ? suf[i+1] : 1);
            prod1 *= nums[i];
        }
        return ans;
    }
}