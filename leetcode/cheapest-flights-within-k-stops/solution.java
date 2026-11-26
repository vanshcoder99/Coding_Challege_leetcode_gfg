class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(var it : flights){
            adj.get(it[0]).add(new int[]{it[1],it[2]});
        }
        Queue<int[]> q = new  LinkedList<>();
        q.offer(new int[]{0,0,src});
        int[] dist = new int[n];
        Arrays.fill(dist,(int)1e9);
        dist[src] = 0;

        while(!q.isEmpty()){
            int[] arr = q.poll();
            int stops = arr[0], d = arr[1],node = arr[2];
            if(stops>k) continue;
            for(var it : adj.get(node)){
                int newnode = it[0],newdis = it[1];
                if(newdis + d < dist[newnode]){
                    dist[newnode] = newdis + d;
                    q.offer(new int[]{stops+1,dist[newnode],newnode});
                }
            }
        }

        if(dist[dst] == (int)1e9) return -1;
        return dist[dst];

    }
}