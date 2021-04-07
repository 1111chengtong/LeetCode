package Algorithms;

import java.util.*;

/**
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sum to target.
 *
 * Each number in candidates may only be used once in the combination.
 *
 * Note: The solution set must not contain duplicate combinations.
 *
 *  
 *
 * Example 1:
 *
 * Input: candidates = [10,1,2,7,6,1,5], target = 8
 * Output:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * Example 2:
 *
 * Input: candidates = [2,5,2,1,2], target = 5
 * Output:
 * [
 * [1,2,2],
 * [5]
 * ]
 *  
 *
 * Constraints:
 *
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/combination-sum-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CombinationSumII {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[candidates.length];
        Arrays.sort(candidates);
        Integer sum = 0;
        backtrack(candidates, target, 0, sum, used, path, ans);
        return ans;
    }

    public void backtrack(int[] candidates, int target, int pos, Integer sum, boolean[] used, Deque<Integer> path, List<List<Integer>> ans) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            ans.add(new ArrayList(path));
            return;
        }
        if (pos == candidates.length) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (!used[i]) {
                if (i > 0 && candidates[i] == candidates[i-1] && !used[i-1]) {
                    continue;
                }
                path.addLast(candidates[i]);
                used[i] = true;
                sum += candidates[i];
                backtrack(candidates, target, i+1, sum, used, path, ans);
                path.removeLast();
                used[i] = false;
                sum -= candidates[i];
            }
        }
    }
}
