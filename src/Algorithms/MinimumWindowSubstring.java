package Algorithms;

/**
 * Given two strings s and t, return the minimum window in s which will contain all the characters in t. If there is no such window in s that covers all characters in t, return the empty string "".
 *
 * Note that If there is such a window, it is guaranteed that there will always be only one unique minimum window in s.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "ADOBECODEBANC", t = "ABC"
 * Output: "BANC"
 * Example 2:
 *
 * Input: s = "a", t = "a"
 * Output: "a"
 *  
 *
 * Constraints:
 *
 * 1 <= s.length, t.length <= 105
 * s and t consist of English letters.
 *  
 *
 * Follow up: Could you find an algorithm that runs in O(n) time?
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/minimum-window-substring
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int sLen = s.length();
        int tLen = t.length();
        char[] charArrayS = s.toCharArray();
        char[] charArrayT = t.toCharArray();
        int[] winFreq = new int[128];
        int[] tFreq = new int[128];
        for (char c : charArrayT) {
            tFreq[c]++;
        }
        // [left, right)
        int left = 0;
        int right = 0;
        int start = 0;
        int minLen = sLen + 1;
        int distance = 0;
        while (right < sLen) {
            char charRight = charArrayS[right];
            if (tFreq[charRight] == 0) {
                right++;
                continue;
            }
            right++;
            winFreq[charRight]++;
            if (winFreq[charRight] <= tFreq[charRight]) {
                distance++;
            }

            while (distance == tLen) {
                if (minLen > right - left) {
                    minLen = right - left;
                    start = left;
                }
                char charLeft = charArrayS[left];
                if (tFreq[charLeft] > 0) {
                    if (winFreq[charLeft] == tFreq[charLeft]) {
                        distance--;
                    }
                    winFreq[charLeft]--;
                }
                left++;
            }

        }

        if (minLen == sLen + 1) {
            return "";
        }
        return s.substring(start, start + minLen);
    }
}
