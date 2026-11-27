class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(var it : times){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }
        int[] dist = new int[n+1];
        Arrays.fill(dist,(int)1e9);
        dist[k] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[0],b[0]));
        pq.offer(new int[]{0,k});
        
        while(!pq.isEmpty()){
            int[] arr = pq.poll();
            int node = arr[1], wt = arr[0];
            for(var it : adj.get(node)){
                int newnode = it[0],newwt = it[1];
                if(wt+newwt < dist[newnode]){
                    dist[newnode] = wt + newwt;
                    pq.offer(new int[]{dist[newnode],newnode});
                }
            }
        }

        int maxi = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == (int)1e9) return -1;
            maxi = Math.max(maxi,dist[i]);
        }
        return maxi;
    }
}