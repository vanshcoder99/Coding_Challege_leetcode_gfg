class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int[][] adjmat = new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i == j) adjmat[i][j] = 0;
                else adjmat[i][j] = (int)1e9;
            }
        }
        for(var it : edges){
            int u = it[0],v=it[1],wt=it[2];
            adjmat[u][v] = wt;
            adjmat[v][u] = wt;
        }

        for(int k=0;k<n;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    adjmat[i][j] = Math.min(adjmat[i][j],adjmat[i][k]+adjmat[k][j]);
                }
            }
        }

        int mini = Integer.MAX_VALUE;
        int val = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(i != j && adjmat[i][j] <= distanceThreshold){
                    cnt++;
                }
            }
            if(mini>=cnt){
                mini = cnt;
                val = i;
            }
        }
        return val;
    }
}