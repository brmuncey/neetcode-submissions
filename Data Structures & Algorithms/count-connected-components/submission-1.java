class Solution {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0; i<n; i++){
            adj.put(i, new HashSet<>());
        }

        for(int[] pair : edges){
            adj.get(pair[0]).add(pair[1]);
            adj.get(pair[1]).add(pair[0]);
        }

        boolean[] visited = new boolean[n];
        int count=0;
        for(int i=0; i<n; i++){
            if(!visited[i]) {
                dfs(i, adj, visited);
                count++;
            }
        }
        return count;
    }

    private void dfs(int i, Map<Integer, Set<Integer>> adj, boolean[] visited){
        if(visited[i]) return;
        visited[i] = true;
        for(Integer v : adj.get(i)){
            dfs(v, adj, visited);
        }
    }
}
