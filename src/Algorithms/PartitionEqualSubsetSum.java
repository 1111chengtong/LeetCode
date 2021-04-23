package Algorithms;

/**
 * Given a non-empty array nums containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 *
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * 1 <= nums[i] <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-equal-subset-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
        }
        if ((sum & 1) == 1) {
            return false;
        }
        int target = sum / 2;
        boolean[][] dp = new boolean[len][target + 1];
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }
        if (nums[0] == target) {
            dp[0][nums[0]] = true;
        }
        for (int i = 1; i < len; i++) {
            for (int j = 1; j < target + 1; j++) {
                if (j < nums[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                }
            }
        }
        return dp[len - 1][target];
    }
}
