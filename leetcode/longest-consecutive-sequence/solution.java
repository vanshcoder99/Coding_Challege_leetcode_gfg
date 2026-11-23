class Solution {
    public int longestConsecutive(int[] nums) {
        int n = nums.length;
        Set<Integer> st = new HashSet<>();
        for(int i=0;i<n;i++) st.add(nums[i]);
        int mcnt = 0;
        for(var it : st){
            if(!st.contains(it-1)){
                int x = it, cnt = 1;
                while(st.contains(x+1)){
                    cnt++;
                    x=x+1;
                }
                mcnt = Math.max(mcnt,cnt);
            }
        }
        return mcnt;
    }
}