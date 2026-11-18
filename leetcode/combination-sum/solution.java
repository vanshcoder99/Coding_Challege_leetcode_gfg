class Solution {
    public void func(int i,int t,int[] can,List<Integer> list,List<List<Integer>> ans) {
        if(i == can.length && t==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(i>=can.length || t<0) return;
        list.add(can[i]);
        func(i,t-can[i],can,list,ans);
        list.remove(list.size()-1);
        func(i+1,t,can,list,ans);
    }
    public List<List<Integer>> combinationSum(int[] can, int t) {
        List<List<Integer>> ans = new ArrayList<>();
        func(0,t,can,new ArrayList<>(),ans);
        return ans;
    }
}