package Algorithms;

import java.util.*;

/**
 * Given a collection of numbers, nums, that might contain duplicates, return all possible unique permutations in any order.
 *
 *  
 *
 * Example 1:
 *
 * Input: nums = [1,1,2]
 * Output:
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * Example 2:
 *
 * Input: nums = [1,2,3]
 * Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 *
 * Constraints:
 *
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PermutationsII {

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque path = new ArrayDeque<>();
        boolean[] userd = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, path, 0, userd, ans);
        return ans;
    }

    public void backtrack(int[] nums, Deque path, int level, boolean[] userd, List<List<Integer>> ans) {
        if (level == nums.length) {
            ans.add(new ArrayList(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (userd[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i-1] && !userd[i-1]) {
                continue;
            }
            path.addLast(nums[i]);
            userd[i] = true;
            backtrack(nums, path, level+1, userd, ans);
            path.removeLast();
            userd[i] = false;
        }
    }
}
