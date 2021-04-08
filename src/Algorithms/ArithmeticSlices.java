package Algorithms;

/**
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *
 * A subarray is a contiguous subsequence of the array.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,4]
 * Output: 3
 * Explanation: We have 3 arithmetic slices in nums: [1, 2, 3], [2, 3, 4] and [1,2,3,4] itself.
 * Example 2:
 *
 * Input: nums = [1]
 * Output: 0
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 5000
 * -1000 <= nums[i] <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/arithmetic-slices
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ArithmeticSlices {

    public int numberOfArithmeticSlices(int[] nums) {
        int len = nums.length;
        if (len < 3) {
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = 0;
        dp[1] = 0;
        if (nums[2] - nums[1] == nums[1] - nums[0]) {
            dp[2] = 1;
        } else {
            dp[2] = 0;
        }
        // n存储nums[i]与之前的元素能形成连续等差子数组的个数
        // dp[i] 存储nums[0]至nums[i]的连续等差子数组的总个数
        // dp[i] = dp[i - 1] + n
        for (int i = 3; i < len; i++) {
            int n = 0;
            for (int j = i; j > 1; j--) {
                if (nums[j] - nums[j - 1] == nums[j - 1] - nums[j -2]) {
                    n++;
                } else {
                    break;
                }
            }
            dp[i] = dp[i - 1] + n;
        }
        return dp[len - 1];


    }
}
