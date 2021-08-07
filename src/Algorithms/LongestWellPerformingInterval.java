package Algorithms;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 1124. Longest Well-Performing Interval
 * We are given hours, a list of the number of hours worked per day for a given employee.
 *
 * A day is considered to be a tiring day if and only if the number of hours worked is (strictly) greater than 8.
 *
 * A well-performing interval is an interval of days for which the number of tiring days is strictly larger than the number of non-tiring days.
 *
 * Return the length of the longest well-performing interval.
 *
 *
 *
 * Example 1:
 *
 * Input: hours = [9,9,6,0,6,6,9]
 * Output: 3
 * Explanation: The longest well-performing interval is [9,9,6].
 *
 *
 * Constraints:
 *
 * 1 <= hours.length <= 10000
 * 0 <= hours[i] <= 16
 */
public class LongestWellPerformingInterval {
    public static void main(String[] args) {
        int[] hours = {6, 6, 9};
        int res = longestWPI(hours);
        System.out.println(res);
    }

    public static int longestWPI(int[] hours) {
        int len = hours.length;
        int[] hours2 = new int[len];
        for (int i = 0; i < len; i++) {
            if (hours[i] > 8) {
                hours2[i] = 1;
            } else {
                hours2[i] = -1;
            }
        }
        int[] prefixSum = new int[len + 1];
        for (int i = 1; i < len + 1; i++) {
            prefixSum[i] = prefixSum[i - 1] + hours2[i - 1];
        }
        Deque<Integer> stack = new LinkedList<>();
        for (int i = 0; i < len + 1; i++) {
            if (stack.isEmpty() || prefixSum[stack.peek()] > prefixSum[i]) {
                stack.push(i);
            }
        }
        int ans = 0;
        for (int j = len; j >= ans; j--) {
            while (!stack.isEmpty()) {
                int i = stack.peek();
                if (prefixSum[j] > prefixSum[i]) {
                    ans = Math.max(ans, j - i);
                    stack.pop();
                } else {
                    break;
                }
            }

        }
        return ans;
    }
}
