class Solution {
    public boolean checkString(String s) {
        int apos = -1,bpos = -1,n = s.length();
        for(int i=0;i<n;i++){
           char ch = s.charAt(i);
           if(ch == 'a'){
            if(bpos != -1) return false;
            else apos = i;
           }
           else{
            if(bpos != -1 && bpos<apos) return false;
            else bpos = i;
           }
        }
        
        return true;
    }
}