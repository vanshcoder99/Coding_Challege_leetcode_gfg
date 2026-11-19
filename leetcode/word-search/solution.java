class Solution {
    public boolean func(int row,int col,int i,char[][] board, String word,boolean[][] vis) {
        if(i == word.length()) return true;
        if(row<0 || row>=board.length || col<0 || col>=board[0].length || vis[row][col] || board[row][col] != word.charAt(i)) return false;
        vis[row][col] = true;
        boolean ans = func(row+1,col,i+1,board,word,vis) || func(row-1,col,i+1,board,word,vis)  || func(row,col+1,i+1,board,word,vis)  || func(row,col-1,i+1,board,word,vis);
        vis[row][col] = false;
        return ans;

    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    if(func(i,j,0,board,word,vis)) return true;
                }
            }
        }
        return false;
    }
}