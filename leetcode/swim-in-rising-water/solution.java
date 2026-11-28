class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{grid[0][0],0,0});
        grid[0][0] = -1;
        int[] delrow = {0,-1,0,1};
        int[] delcol = {-1,0,1,0};
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int dist = arr[0], r = arr[1], c = arr[2];
            if(r == n-1 && c == m-1) return dist;
            for(int i=0;i<4;i++){
                int nr = r + delrow[i], nc = c + delcol[i];
                if(nr>=0 && nc>=0 && nr<n && nc < m && grid[nr][nc] != -1){
                    int maxi = Math.max(dist,grid[nr][nc]);
                    grid[nr][nc] = -1;
                    pq.offer(new int[]{maxi,nr,nc});
                }
            }
        }
        return -1;
    }
}