package Algorithms;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] >= target) {
                return i;
            }
            i++;
        }
        return i;
    }
}
