class Solution {
    public int reverseBits(int n) {
        int ans = 0,i=0;
        while(i<32){
            int num = n & 1;
            if(num!=0) ans+=1*(int)Math.pow(2,31-i);
            n=n>>1;
            i++;
        }
        return ans;
    }
}