package Algorithms;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.
 *
 * Follow up: Your solution should run in O(log n) time and O(1) space.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,1,2,3,3,4,4,8,8]
 * Output: 2
 * Example 2:
 *
 * Input: nums = [3,3,7,7,10,11,11]
 * Output: 10
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 10^5
 * 0 <= nums[i] <= 10^5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/single-element-in-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SingleElementInASortedArray {

    public int singleNonDuplicate(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        int mid;

        while (low < high) {
            mid = low + (high - low) / 2;
            boolean halvesEven = (high - mid) % 2 == 0;
            if (nums[mid] == nums[mid + 1]) {
                if (halvesEven) {
                    low = mid + 2;
                } else {
                    high = mid - 1;
                }
            } else if (nums[mid] == nums[mid - 1]) {
                if (halvesEven) {
                    high = mid - 2;
                } else {
                    low = mid + 1;
                }
            } else {
                return nums[mid];
            }
        }
        return nums[low];
    }
}
