class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0; i<n; i++) adj.put(i, new HashSet<>());

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int count = 0;
        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<n; i++){
            if(!visited.contains(i)) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int cur, Map<Integer, Set<Integer>> adj, Set<Integer> v){
        if(v.contains(cur)) return;
        v.add(cur);

        for(int i : adj.get(cur)){
            dfs(i, adj, v);
        }
    }
}
