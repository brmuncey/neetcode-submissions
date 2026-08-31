class Solution {
    public boolean validTree(int n, int[][] edges) {
        if(n == 0) return true;

        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0; i<n; i++){
            adj.put(i, new HashSet<>());
        }

        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(0, -1, adj, visited) && n == visited.size();
    }

    private boolean dfs(int i, int p, Map<Integer, Set<Integer>> adj, Set<Integer> visited){
        if(visited.contains(i)) return false;
        visited.add(i);
        for(int j : adj.get(i)){
            if(j == p) continue;
            if(!dfs(j, i, adj, visited)) return false;
        }
        return true;
    }
}
