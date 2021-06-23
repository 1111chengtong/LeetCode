package Algorithms;

/**
 * You are given an integer array nums and an integer target.
 *
 * You want to build an expression out of nums by adding one of the symbols '+' and '-' before each integer in nums and then concatenate all the integers.
 *
 * For example, if nums = [2, 1], you can add a '+' before 2 and a '-' before 1 and concatenate them to build the expression "+2-1".
 * Return the number of different expressions that you can build, which evaluates to target.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,1,1], target = 3
 * Output: 5
 * Explanation: There are 5 ways to assign symbols to make the sum of nums be target 3.
 * -1 + 1 + 1 + 1 + 1 = 3
 * +1 - 1 + 1 + 1 + 1 = 3
 * +1 + 1 - 1 + 1 + 1 = 3
 * +1 + 1 + 1 - 1 + 1 = 3
 * +1 + 1 + 1 + 1 - 1 = 3
 * Example 2:
 *
 * Input: nums = [1], target = 1
 * Output: 1
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 20
 * 0 <= nums[i] <= 1000
 * 0 <= sum(nums[i]) <= 1000
 * -1000 <= target <= 1000
 * 通过次数122,437提交次数246
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/target-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TargetSum {

    public int findTargetSumWays(int[] nums, int target) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if (Math.abs(target) > sum) {
            return 0;
        }
        int t = 2 * sum + 1;

        int[][] dp = new int[len][t];
        if (nums[0] == 0) {
            dp[0][sum] = 2;
        } else {
            dp[0][sum - nums[0]] = dp[0][sum + nums[0]] = 1;
        }
        for (int i = 1; i < len; i++) {
            for (int j = -sum; j <= sum; j++) {
                if (sum + j + nums[i] >= t) {
                    dp[i][sum + j] = dp[i - 1][sum + j -nums[i]] + 0;
                } else if (sum + j - nums[i] < 0) {
                    dp[i][sum + j] = dp[i - 1][sum + j + nums[i]] + 0;
                } else {
                    dp[i][sum + j] = dp[i - 1][sum + j + nums[i]] + dp[i - 1][sum + j - nums[i]];
                }

            }
        }
        return dp[len - 1][sum + target];

    }
}
