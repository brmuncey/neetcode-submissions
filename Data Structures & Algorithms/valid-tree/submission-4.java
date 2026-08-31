class Solution {
    public boolean validTree(int n, int[][] edges) {
        Map<Integer, Set<Integer>> adj = new HashMap<>();
        for(int i=0; i<n; i++) adj.put(i, new HashSet<>());
        for(int[] e : edges){
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        Set<Integer> visited = new HashSet<>();
        return dfs(0, -1, adj, visited) && visited.size() == n;
    }

    private boolean dfs(int c, int p, Map<Integer, Set<Integer>> adj, Set<Integer> visited){
        if(visited.contains(c)) return false;
        visited.add(c);

        for(int i : adj.get(c)){
            if(i == p) continue;
            if(!dfs(i, c, adj, visited)) return false;
        }
        return true;
    }
}
