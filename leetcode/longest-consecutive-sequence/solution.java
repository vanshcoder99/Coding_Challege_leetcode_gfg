class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        Arrays.sort(nums);
        int x = nums[0],mcnt=1,cnt=1,i=1;
        while(i<n){
            if(x+1==nums[i]){
                cnt++;
                x=x+1;
            }
            else if(x!=nums[i]){
                x=nums[i];
                cnt = 1;
            }
            mcnt = Math.max(mcnt,cnt);
            i++;
        }
        return mcnt;
    }
}