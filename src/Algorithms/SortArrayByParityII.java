package Algorithms;

/**
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 *
 * You may return any answer array that satisfies this condition.
 *
 *  
 *
 * Example 1:
 *
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *  
 *
 * Note:
 *
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-array-by-parity
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortArrayByParityII {
    public int[] sortArrayByParityII(int[] A) {
        int i = 0;
        int j = 1;
        int[] result = new int[A.length];
        for (int index = 0; index < A.length; index++) {
            if (A[index] % 2 == 0) {
                result[i] = A[index];
                i += 2;
            } else {
                result[j] = A[index];
                j += 2;
            }
        }
        return result;
    }

    // public static void main(String[] args) {
    //     int[] result = sortArrayByParity(new int[] {4, 2, 5, 7});
    //     for (int num : result) {
    //         System.out.println(num);
    //     }
    // }
}
