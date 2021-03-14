package Algorithms;

/**
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-palindrome-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        return validPal(s, 1);
    }
    public boolean validPal(String s, int chance) {
        int len = s.length();
        char[] charArrayS = s.toCharArray();
        int i = 0;
        int j = len - 1;

        while (i <= j) {
            if (charArrayS[i] == charArrayS[j]) {
                i++;
                j--;
            } else {
                if (chance < 1) {
                    return false;
                }
                chance--;
                return validPal(s.substring(i, j), chance) || validPal(s.substring(i+1, j+1), chance);
            }
        }
        return true;
    }
}
