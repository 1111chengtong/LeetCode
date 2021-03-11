package Algorithms;

import java.util.Arrays;
import java.util.Comparator;

/**
 * There are some spherical balloons spread in two-dimensional space. For each balloon, provided input is the start and end coordinates of the horizontal diameter. Since it's horizontal, y-coordinates don't matter, and hence the x-coordinates of start and end of the diameter suffice. The start is always smaller than the end.
 *
 * An arrow can be shot up exactly vertically from different points along the x-axis. A balloon with xstart and xend bursts by an arrow shot at x if xstart ≤ x ≤ xend. There is no limit to the number of arrows that can be shot. An arrow once shot keeps traveling up infinitely.
 *
 * Given an array points where points[i] = [xstart, xend], return the minimum number of arrows that must be shot to burst all balloons.
 *
 *  
 *
 * Example 1:
 *
 * Input: points = [[10,16],[2,8],[1,6],[7,12]]
 * Output: 2
 * Explanation: One way is to shoot one arrow for example at x = 6 (bursting the balloons [2,8] and [1,6]) and another arrow at x = 11 (bursting the other two balloons).
 * Example 2:
 *
 * Input: points = [[1,2],[3,4],[5,6],[7,8]]
 * Output: 4
 * Example 3:
 *
 * Input: points = [[1,2],[2,3],[3,4],[4,5]]
 * Output: 2
 * Example 4:
 *
 * Input: points = [[1,2]]
 * Output: 1
 * Example 5:
 *
 * Input: points = [[2,3],[2,3]]
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 0 <= points.length <= 104
 * points[i].length == 2
 * -231 <= xstart < xend <= 231 - 1
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumNumberOfArrowsToBurstBalloons {
    public static void main(String[] args) {
        int[][] arr = new int[][]{new int[]{-2147483646,-2147483645}, new int[] {2147483646,2147483647}};
        int ret = findMinArrowShots(arr);
        System.out.println(ret);
    }
    public static int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 按右断点升序排序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] o1, int[] o2) {
                // 此种写法有错误，正常情况下，当o1[1] > o2[1]，o1[1] - o2[1]的结果为正，但当
                // o1[1]为正且较大接近231 - 1， 而 o2[1]为负且接近-231，会发生溢出，结果为负
                // return o1[1] - o2[1];
                return o1[1] < o2[1] ? -1 : 1;
            }
        });
        int ret = 1;
        for (int i = 1; i < points.length; i++) {
            if (points[i][0] <= points[i - 1][1]) {
                points[i][1] = points[i - 1][1];
            } else {
                ret++;
            }
        }
        return ret;
    }
}
