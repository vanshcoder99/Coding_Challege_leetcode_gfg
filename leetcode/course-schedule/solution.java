class Solution {
    public boolean canFinish(int n, int[][] pre) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] indeg = new int[n];
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(var it : pre){
            adj.get(it[1]).add(it[0]);
            indeg[it[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(indeg[i] == 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.poll();
            cnt++;
            for(var it : adj.get(node)){
                indeg[it]--;
                if(indeg[it] == 0) q.offer(it);
            }
        }
        if(cnt != n) return false;
        return true;

    }
}