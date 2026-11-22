class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        if(n == 0) return ans;
        boolean vis[] = new boolean[n];
        for(int i=0;i<n;i++){
            if(vis[i]) continue; 
            List<String> list = new ArrayList<>();
            String s = strs[i];
            int[] hash1 = new int[26];
            for(int k=0;k<s.length();k++){
                hash1[s.charAt(k)-'a']++;
            }
            for(int j=i+1;j<n;j++){
                int size = strs[j].length();
                if(vis[j] || size != s.length()) continue;
                int[] hash2 = new int[26];
                String s1 = strs[j];
                for(int k=0;k<size;k++) hash2[s1.charAt(k)-'a']++;
                if(Arrays.equals(hash1,hash2)){
                    list.add(s1);
                    vis[j] = true;
                }
            }
            list.add(s);
            ans.add(list);
        }
        return ans;
    }
}