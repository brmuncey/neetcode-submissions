class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++) map.put(i, new ArrayList<>());
        for(int[] p : prerequisites) map.get(p[0]).add(p[1]);

        Set<Integer> visited = new HashSet<>();
        for(int i=0; i<numCourses; i++) {
            if(!dfs(i, map, visited)) return false;
        }

        return true;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited){
        if(visited.contains(i)) return false;
        if(map.get(i).isEmpty()) return true;

        visited.add(i);
        for(int p : map.get(i)){
            if(!dfs(p, map, visited)) return false;
        }
        visited.remove(i);
        map.get(i).clear();
        return true;
    }
}
