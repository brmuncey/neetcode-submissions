class Node {

    int[] points;
    double distance;

    public Node(int[] points, double distance){
        this.points = points;
        this.distance = distance;
    }

}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> maxHeap = new PriorityQueue<Node>((a,b) -> Double.compare(b.distance, a.distance));
        for(int[] p : points){
            double x = Math.pow(p[0], 2);
            double y = Math.pow(p[1], 2);
            double distance = Math.sqrt(x + y);
            maxHeap.offer(new Node(p, distance));

            if(maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        
        int[][] result = new int[k][2];
        int i = 0;
        while(!maxHeap.isEmpty()){
            result[i++] = maxHeap.poll().points;
        }
        return result;
    }
}