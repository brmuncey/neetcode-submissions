class Element {

    int key;
    int val;

    public Element(int key, int val){
        this.key = key;
        this.val = val;
    }

}

class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n : nums) map.put(n, map.getOrDefault(n, 0) + 1);

        PriorityQueue<Element> maxHeap = new PriorityQueue<>((a,b) -> b.val - a.val);
        for(int key : map.keySet()){
            maxHeap.offer(new Element(key, map.get(key)));
        }

        return maxHeap.isEmpty() ? -1 : maxHeap.poll().key;
    }
}