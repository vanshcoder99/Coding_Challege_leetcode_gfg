class Solution {
    public int minChanges(String s) {
        int n = s.length();
        int i = 0, j = 1, cnt = 0;
        while(i<n && j<n){
            int val1 = s.charAt(i)-'0',val2 = s.charAt(j)-'0';
            if((val1 + val2) % 2 == 1) cnt++;
            i+=2;
            j+=2;
        }
        return cnt;
    }
}