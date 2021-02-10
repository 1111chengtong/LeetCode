package Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 *
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 *
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 *
 *  
 *
 * Example 1:
 *
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 *
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 *  
 *
 * Note:
 *
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/k-closest-points-to-origin
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class KClosestPointsToOrigin {

    public int[][] kClosest(int[][] points, int K) {
        //pq是大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                return getDistance(point2) - getDistance(point1);
            }
        });
        for (int i = 0; i < points.length; i++) {
            if (pq.size() < K) {
                pq.offer(points[i]);
            } else {
                if (getDistance(points[i]) < getDistance(pq.peek())) {
                    pq.poll();
                    pq.offer(points[i]);
                }
            }
        }
        int[][] result = new int[K][];
        for (int i = 0; i < K; i++) {
            result[i] = pq.poll();
        }
        return result;
    }
    int getDistance(int[] point) {
        return point[0]*point[0] + point[1]*point[1];
    }
}
