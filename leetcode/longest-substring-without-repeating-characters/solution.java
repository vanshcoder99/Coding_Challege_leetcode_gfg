class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if(n == 0 || n == 1) return n;
        int mlen = 0,l=0;
        int[] hash = new int[256];
        for(int r=0;r<n;r++){
            char ch = s.charAt(r);
            while(hash[ch] != 0){
                hash[s.charAt(l)] = 0;
                l++;
            }
            hash[ch] = 1;
            mlen = Math.max((r-l+1),mlen);
        }
        return mlen;
    }
}