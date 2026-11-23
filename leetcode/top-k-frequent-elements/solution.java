class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        int[] arr = new int[k];
        Map<Integer,Integer> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            int val = nums[i];
            mpp.put(val,mpp.getOrDefault(val,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(b[1],a[1]));
        for(var it : mpp.keySet()){
            pq.offer(new int[]{it,mpp.get(it)});
        }
        int i = 0;
        while(i<k && !pq.isEmpty()){
            arr[i++] = pq.poll()[0];
        }
        return arr;
    }
}