class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        if(n == 0) return ans;
        HashMap<String,List<String>> mpp = new HashMap<>();
        for(int i=0;i<n;i++){
            char[] hash = new char[26];
            String s = strs[i];
            for(int j=0;j<s.length();j++) hash[s.charAt(j)-'a']++;
            String arr = new String(hash);
            if(mpp.containsKey(arr)){
                List<String> list = mpp.get(arr);
                list.add(s);
            }
            else {
                List<String> list = new ArrayList<>();
                list.add(s);
                mpp.put(arr,list);
            }
        }
        for(var it : mpp.values()){
            ans.add(it);
        }
        return ans;
    }
}