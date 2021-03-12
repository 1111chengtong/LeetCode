package Algorithms;

/**
 * Given an array nums with n integers, your task is to check if it could become non-decreasing by modifying at most one element.
 *
 * We define an array is non-decreasing if nums[i] <= nums[i + 1] holds for every i (0-based) such that (0 <= i <= n - 2).
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [4,2,3]
 * Output: true
 * Explanation: You could modify the first 4 to 1 to get a non-decreasing array.
 * Example 2:
 *
 * Input: nums = [4,2,1]
 * Output: false
 * Explanation: You can't get a non-decreasing array by modify at most one element.
 *  
 *
 * Constraints:
 *
 * n == nums.length
 * 1 <= n <= 104
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/non-decreasing-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Non_decreasingArray {
    public boolean checkPossibility(int[] nums) {
        if (nums.length <= 1) return true;
        int chance = 1;
        if (nums[0] > nums[1]) {
            nums[0] = Integer.MIN_VALUE;
            chance--;
        }
        for (int i = 1; i < nums.length - 1; i++) {

            if (nums[i] > nums[i + 1]) {
                if (chance == 0) {
                    return false;
                }
                if (nums[i - 1] > nums[i+1]) {
                    nums[i+1] = nums[i];
                    chance--;
                } else {
                    nums[i] = nums[i-1];
                    chance--;
                }
            }
        }
        return true;
    }
}
