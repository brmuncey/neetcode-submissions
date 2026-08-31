class Pair {
    Character val;
    int count;
    int time;

    public Pair(Character val, int count){
        this.val = val;
        this.count = count;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a,b) -> b.count - a.count);
        Queue<Pair> queue = new LinkedList<>();

        Map<Character, Integer> map = new HashMap<>();
        for(char c : tasks) map.put(c, map.getOrDefault(c, 0) + 1);
        for(Character k : map.keySet()) maxHeap.offer(new Pair(k, map.get(k)));
        int time = 0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){
            time += 1;

            if(!maxHeap.isEmpty()){
                Pair p = maxHeap.poll();
                p.count--;
                if(p.count > 0) {
                    p.time = time + n;
                    queue.offer(p);
                }

            }

            if(!queue.isEmpty() && queue.peek().time == time){
                maxHeap.offer(queue.poll());
            }
        }
        return time;
    }
}