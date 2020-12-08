package Algorithms;

import java.util.HashSet;
import java.util.Set;

/**
 * 3. Longest Substring Without Repeating Characters
 *
 * Given a string s, find the length of the longest substring without repeating characters.
 *
 * Example 1:
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null) return 0;
        // len 字符串长度
        int len = s.length();
        // 将字符放入到集合中
        Set<Character> occ = new HashSet<>();
        // ans 记录最大长度
        int ans = 0;
        // rk表示右指针，初始为-1
        int rk = -1;
        // i表示左指针
        for (int i = 0; i < len; i++) {
            if (i != 0) {
                // i右移要将左边的字符从集合中去掉
                occ.remove(s.charAt(i -1));
            }
            while (rk + 1 < len && !occ.contains(s.charAt(rk + 1))) {
                // 若不重复，则将字符加入集合
                occ.add(s.charAt((rk +1)));
                rk++;
            }
            ans = Math.max(ans, rk - i +1);
        }
        return ans;
    }
}
