package Algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array of integers heights representing the histogram's bar height where the width of each bar is 1, return the area of the largest rectangle in the histogram.
 *
 *  
 *
 * Example 1:
 *
 *
 * Input: heights = [2,1,5,6,2,3]
 * Output: 10
 * Explanation: The above is a histogram where width of each bar is 1.
 * The largest rectangle is shown in the red area, which has an area = 10 units.
 * Example 2:
 *
 *
 * Input: heights = [2,4]
 * Output: 4
 *  
 *
 * Constraints:
 *
 * 1 <= heights.length <= 105
 * 0 <= heights[i] <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] heights) {
        if (heights == null) {
            return 0;
        }
        int len = heights.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(right, len);
        Deque<Integer> stack = new ArrayDeque<>();
        int maxArea = 0;
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && heights[stack.peekLast()] >= heights[i]) {
                right[stack.peekLast()] = i;
                stack.removeLast();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peekLast();
            stack.addLast(i);
        }
        for (int i = 0; i < len; i++) {
            maxArea = Math.max(maxArea, (right[i] - left[i] - 1) * heights[i]);
        }
        return maxArea;
    }
}
