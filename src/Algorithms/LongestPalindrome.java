package Algorithms;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *
 * Letters are case sensitive, for example, "Aa" is not considered a palindrome here.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "abccccdd"
 * Output: 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * Example 2:
 *
 * Input: s = "a"
 * Output: 1
 * Example 3:
 *
 * Input: s = "bb"
 * Output: 2
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 2000
 * s consists of lowercase and/or uppercase English letters only.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestPalindrome {

    public int longestPalindrome(String s) {
        int[] a = new int[58];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'A']++;
        }
        int longestLen = 0;
        for (int i = 0; i < 58; i++) {
            longestLen += a[i] / 2 * 2;
            if (a[i] % 2 == 1 && longestLen % 2 ==0) {
                longestLen++;
            }
        }
        return longestLen;
    }
}
