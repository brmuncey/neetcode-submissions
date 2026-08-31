class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Map<Integer, List<int[]>> adj = new HashMap<>();
        for(int[] arr : times){
            if(!adj.containsKey(arr[0])) adj.put(arr[0], new ArrayList<>());
            adj.get(arr[0]).add(new int[]{arr[1], arr[2]});
        }

        Map<Integer, Integer> dist = new HashMap<>();
        for(int i=1; i <=n; i++) dist.put(i, Integer.MAX_VALUE);
        dist.put(k, 0);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {k, 0});

        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int node = cur[0], time = cur[1];
            if(dist.get(node) < time) {
                continue;
            }

            if (adj.containsKey(node)) {
                for(int[] nei : adj.get(node)){
                    int next = nei[0], weight = nei[1];
                    if(time + weight < dist.get(next)){
                        dist.put(next, time + weight);
                        queue.offer(new int[] {next, time + weight});
                    }
                }
            }
        }
        int res = Collections.max(dist.values());
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}