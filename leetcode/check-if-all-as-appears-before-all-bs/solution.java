class Solution {
    public boolean checkString(String s) {
        int cnta = 0,n = s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i) == 'a') cnta++;
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == 'a') cnta--;
            else if(ch == 'b' && cnta != 0) return false;
            else if(cnta == 0) return true;
        }
        return true;
    }
}