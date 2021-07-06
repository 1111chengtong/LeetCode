package Algorithms;

import java.util.Random;

/**
 * We are playing the Guess Game. The game is as follows:
 *
 * I pick a number from 1 to n. You have to guess which number I picked.
 *
 * Every time you guess wrong, I will tell you whether the number I picked is higher or lower than your guess.
 *
 * You call a pre-defined API int guess(int num), which returns 3 possible results:
 *
 * -1: The number I picked is lower than your guess (i.e. pick < num).
 * 1: The number I picked is higher than your guess (i.e. pick > num).
 * 0: The number I picked is equal to your guess (i.e. pick == num).
 * Return the number that I picked.
 *
 *  
 *
 * Example 1:
 *
 * Input: n = 10, pick = 6
 * Output: 6
 * Example 2:
 *
 * Input: n = 1, pick = 1
 * Output: 1
 * Example 3:
 *
 * Input: n = 2, pick = 1
 * Output: 1
 * Example 4:
 *
 * Input: n = 2, pick = 2
 * Output: 2
 *  
 *
 * Constraints:
 *
 * 1 <= n <= 231 - 1
 * 1 <= pick <= n
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/guess-number-higher-or-lower
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


public class GuessNumberHigherOrLower {

    int guess(int num) {
        Random r = new Random();
        int pick = r.nextInt(num) + 1;
        if (pick < num) {
            return -1;
        }
        if (pick > num) {
            return 1;
        }
        return 0;
    }
    public int guessNumber(int n) {
        return guessNumber(1, n);
    }

    public int guessNumber(int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = left + (right - left) / 2;
        if (guess(mid) == -1) {
            return guessNumber(left, mid - 1);
        } else if (guess(mid) == 1) {
            return guessNumber(mid + 1, right);
        } else {
            return mid;
        }
    }
}
