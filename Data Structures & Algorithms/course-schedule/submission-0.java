class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i=0; i<numCourses; i++){
            map.put(i, new ArrayList<>());
        }

        for(int i=0; i<prerequisites.length; i++){
            map.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        Set<Integer> set = new HashSet<>();
        for(int i=0; i<numCourses; i++){
            if(!dfs(i, map, set)) return false;
        }

        return true;
    }

    private boolean dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> set){
        if(set.contains(i)) return false;
        if(map.get(i).isEmpty()) return true;

        set.add(i);
        for(Integer p : map.get(i)){
            if(!dfs(p, map, set)) return false;
        }
        set.remove(i);
        map.get(i).clear();
        return true;
    }
}
