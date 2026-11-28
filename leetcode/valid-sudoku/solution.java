class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = 9;
        for(int i=0;i<n;i++){
            Set<Integer> st1 = new HashSet<>();
            Set<Integer> st2 = new HashSet<>();
            for(int j=0;j<n;j++){
                char ch1 = board[i][j],ch2 = board[j][i];
                if(ch1 != '.'){
                    if(st1.contains(ch1-'0')) return false;
                    st1.add(ch1-'0');
                }
                if(ch2 != '.'){
                    if(st2.contains(ch2-'0')) return false;
                    st2.add(ch2-'0');
                }
            }
        }

        for(int i=0;i<n;i+=3){
            for(int j=0;j<n;j+=3){
                Set<Integer> st1 = new HashSet<>();
                for(int k=0;k<3;k++){
                    for(int l=0;l<3;l++){
                        char ch1 = board[i+k][j+l];
                        if(ch1 == '.') continue;
                        if(st1.contains(ch1-'0')) return false;
                        st1.add(ch1-'0');
                    }
                }   
            }
        }
        return true;


    }
}