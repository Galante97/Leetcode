/*
 * 973. K Closest Points to Origin
 * Given an array of points where points[i] = [xi, yi] represents a point on the
 * X-Y plane and an integer k, return the k closest points to the origin (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)2 + (y1 - y2)2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be unique
 * (except for the order that it is in).
 */
public class PointData {
    double distance;
    int[] coord = new int[2];
}

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        //sorted by distance 
        PriorityQueue<PointData> heap = new PriorityQueue<PointData>((a, b) -> Double.compare(a.distance, b.distance));

        // find the point distance
        for (var point : points) {
            PointData data = new PointData();
            var distance = Math.sqrt((Math.pow(point[0], 2)) + (Math.pow(point[1], 2)));
            data.coord = point;
            data.distance = distance;

            heap.add(data);
        }

        //output array
        int[][] output = new int[k][1];
        
        //poll until k
        for (int i = 0; i < k; i++) {
            var curr = heap.poll();
            output[i] = curr.coord;
        }

        return output;
    }
}










//ALTERNATE SOLUTION WITH CUSTOM COMPARE
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        // Sort the array with a custom lambda comparator function
        Arrays.sort(points, (a, b) -> squaredDistance(a) - squaredDistance(b));

        // Return the first k elements of the sorted array
        return Arrays.copyOf(points, k);
    }

    private int squaredDistance(int[] point) {
        // Calculate and return the squared Euclidean distance
        return point[0] * point[0] + point[1] * point[1];
    }
};