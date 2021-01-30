package Algorithms;

/**
 * /**
 *  * Given two strings s and t , write a function to determine if t is an anagram of s.
 *  *
 *  * Example 1:
 *  *
 *  * Input: s = "anagram", t = "nagaram"
 *  * Output: true
 *  * Example 2:
 *  *
 *  * Input: s = "rat", t = "car"
 *  * Output: false
 *  * Note:
 *  * You may assume the string contains only lowercase alphabets.
 *  *
 *  * Follow up:
 *  * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 *  *
 *  * 来源：力扣（LeetCode）
 *  * 链接：https://leetcode-cn.com/problems/valid-anagram
 *  * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  */

import java.util.Arrays;
public class ValidAnagram2 {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] str1 = s.toCharArray();
        char[] str2 = t.toCharArray();
        Arrays.sort(str1);
        Arrays.sort(str2);
        return Arrays.equals(str1, str2);
    }


}
