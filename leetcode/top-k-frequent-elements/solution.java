class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[k];
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = nums[i];
            mpp.put(val,mpp.getOrDefault(val,0)+1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(mpp.get(a),mpp.get(b)));

        for(var it : mpp.keySet()){
            pq.offer(it);
             if(pq.size()>k){
                pq.poll();
            }
        }
        int i = 0;
        while(!pq.isEmpty() && i<k){
            arr[i++] = pq.poll();
        }
        return arr;
    }
}