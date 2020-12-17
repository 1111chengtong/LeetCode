package Algorithms;

/**
 * 8. String to Integer (atoi)
 * Implement atoi which converts a string to an integer.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.
 *
 * The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.
 *
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 *
 * If no valid conversion could be performed, a zero value is returned.
 *
 * Note:
 *
 * Only the space character ' ' is considered a whitespace character.
 * Assume we are dealing with an environment that could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, 231 − 1 or −231 is returned.
 *  
 *
 * Example 1:
 *
 * Input: str = "42"
 * Output: 42
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class StringToInteger {
    public int myAtoi(String s) {
        int len = s.length();
        // s为空字符串
        if (len == 0) return 0;

        char[] charArray = s.toCharArray();
        int index = 0;
        // 过滤前导空格
        while (index < len) {
            if (charArray[index] == ' ') {
                index++;
            } else {
                break;
            }
        }
        if (index == len) return 0;

        int flag = 1;
        int res = 0;
        if (charArray[index] == '-') {
            flag = -1;
            index++;
        } else if (charArray[index] == '+') {
            index++;
        }
        while(index < len) {
            if (charArray[index] < '0' || charArray[index] > '9') break;
            if (flag == 1 && (res > Integer.MAX_VALUE / 10 || res == Integer.MAX_VALUE / 10 && charArray[index]-'0' > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (flag == -1 && (-res < Integer.MIN_VALUE / 10 || -res == Integer.MIN_VALUE / 10 && charArray[index]-'0' > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + (charArray[index] - '0');
            index++;
        }
        return flag == 1 ? res : -res;


    }
}
