class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++) map.put(i, new ArrayList<>());
        for(int[] p : prerequisites) map.get(p[0]).add(p[1]);

        Set<Integer> visited = new HashSet<>();
        Set<Integer> cycle = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, map, visited, cycle, list)) return new int[0];
        }

        int[] res = new int[numCourses];
        for(int i=0; i<numCourses; i++) res[i] = list.get(i);
        return res;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> visited, Set<Integer> cycle, List<Integer> list){
        if(cycle.contains(i)) return false;
        if(visited.contains(i)) return true;

        cycle.add(i);
        for(int p : map.get(i)){
            if(!dfs(p, map, visited, cycle, list)) return false;
        }

        cycle.remove(i);
        visited.add(i);
        list.add(i);
        return true;
    }
}