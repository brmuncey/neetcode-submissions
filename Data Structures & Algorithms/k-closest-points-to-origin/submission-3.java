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
            double distance =  p[0] * p[0] + p[1] * p[1];
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