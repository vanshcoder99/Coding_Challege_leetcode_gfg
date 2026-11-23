class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n+1];
        int[] suf = new int[n+1];
        pre[0] = 1;
        suf[n] = 1;
        int prod1 = 1, prod2 = 1;
        for(int i=0;i<n;i++){
            prod1*=nums[i];
            prod2*=nums[n-i-1];
            pre[i+1] = prod1;
            suf[n-i-1] = prod2;
        }
        int[] ans = new int[n];
        for(int i=1;i<=n;i++){
            ans[i-1] = pre[i-1] * suf[i];
        }
        return ans;
    }
}