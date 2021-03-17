package Algorithms;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * Example 2:
 *
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * Example 3:
 *
 * Input: nums1 = [0,0], nums2 = [0,0]
 * Output: 0.00000
 * Example 4:
 *
 * Input: nums1 = [], nums2 = [1]
 * Output: 1.00000
 * Example 5:
 *
 * Input: nums1 = [2], nums2 = []
 * Output: 2.00000
 *  
 *
 * Constraints:
 *
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 *  
 *
 * Follow up: The overall run time complexity should be O(log (m+n)).
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MedianOfTwoSortedArrays2 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int left = (m + n + 1) / 2;
        int right = (m + n + 2) / 2;
        return (findKthSortedArray(nums1, 0, m - 1, nums2, 0, n - 1, left) + findKthSortedArray(nums1, 0, m - 1, nums2, 0, n - 1, right)) * 0.5;

    }

    public int findKthSortedArray(int[] nums1, int start1, int end1, int[] nums2, int start2, int end2, int K) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;

        if (len1 > len2) {
            return findKthSortedArray(nums2, start2, end2, nums1, start1, end1, K);
        }

        if (len1 == 0) {
            return nums2[start2 + K - 1];
        }
        if (K == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int i = start1 + Math.min(K / 2, len1) - 1;
        int j = start2 + Math.min(K / 2, len2) - 1;
        if (nums1[i] < nums2[j]) {
            return findKthSortedArray(nums1, i+1 , end1, nums2, start2, end2, K - (i - start1 + 1));
        } else {
            return findKthSortedArray(nums1, start1 , end1, nums2, j + 1, end2, K - (j - start2 + 1));
        }

    }
}
