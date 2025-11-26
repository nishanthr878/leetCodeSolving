import java.util.PriorityQueue;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int []> pq = new PriorityQueue<>(
                (a, b) -> Double.compare(distance(b), distance(a))
        );

        for(int[] p : points) {
            pq.add(p);
            if(pq.size() > k) {
                pq.poll();
            }
        }

        int[][] result = new int[k][2];
        int i = 0;
        while(!pq.isEmpty()){
            result[i++] = pq.poll();
        }
        return result;
    }

    private double distance(int[] p) {
        return p[0] * p[0] + p[1] * p[1];
    }

    public static void main(String[] args) {
        KClosest solver = new KClosest();
        int[][] points = {{1,3},{-2,2},{5,8},{0,1}};
        int k = 2;
        int[][] closestPoints = solver.kClosest(points, k);

        for(int[] point : closestPoints) {
            System.out.println("[" + point[0] + ", " + point[1] + "]");
        }
    }
}
