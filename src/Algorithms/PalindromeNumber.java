package Algorithms;

/**
 * 9. Palindrome Number
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Follow up: Could you solve it without converting the integer to a string?
 *
 *  
 *
 * Example 1:
 *
 * Input: x = 121
 * Output: true
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/palindrome-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x % 10 == 0 && x != 0) return false;

        int revertedNumber = 0;
        while ( x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x = x / 10;
        }
        if (x == revertedNumber || x == revertedNumber / 10) {
            return true;
        } else {
            return false;
        }

    }
}
