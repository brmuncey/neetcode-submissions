class Entry {
    double val;
    int[] coords;

    public Entry(double val, int[] coords){
        this.val = val;
        this.coords = coords;
    }
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Entry> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b.val, a.val));
        for(int[] p : points){
            double v = Math.sqrt(Math.pow(p[0], 2) + Math.pow(p[1], 2));
            maxHeap.offer(new Entry(v, p));
            while(maxHeap.size() > k) maxHeap.poll();
        }

        int[][] res = new int[k][2];
        for(int i=0; i<k; i++){
            res[i] = maxHeap.poll().coords;
        }

        return res;
    }
}
