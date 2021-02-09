package Algorithms;

/**
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.
 *
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
 *
 * Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/daily-temperatures
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DailyTemperatures {

    public int[] dailyTemperatures(int[] T) {
        int len = T.length;
        int[] days = new int[len];
        for (int i = 0; i < len; i++) {
            boolean hasWarmer = false;
            int count = 1;
            for (int j = i+1; j < len; j++) {
                if (T[j] > T[i]) {
                    hasWarmer = true;
                    break;
                } else {
                    count++;
                }
            }
            if (hasWarmer) {
                days[i] = count;
            } else {
                days[i] = 0;
            }
        }
        return days;
    }
}
