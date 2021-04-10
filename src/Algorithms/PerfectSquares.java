package Algorithms;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *
 * A perfect square is an integer that is the square of an integer; in other words, it is the product of some integer with itself. For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 104
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/perfect-squares
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PerfectSquares {

    public int numSquares(int n) {
        /*int[] dp = new int[n+1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            double sqrt = Math.sqrt(i);
            if (sqrt == Math.floor(sqrt)) {
                dp[i] = 1;
            } else {
                int leastNum = i;
                for (int j = 1; j <= i / 2; j++) {
                    leastNum = Math.min(leastNum, dp[j] + dp[i - j]);
                }
                dp[i] = leastNum;
            }

        }
        return dp[n];*/
        int[] dp = new int[n+1];
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = i;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        int res = perfectSquares.numSquares(12);
        System.out.println(res);
    }
}
