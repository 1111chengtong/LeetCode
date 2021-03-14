package Algorithms;

import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a string array dictionary, return the longest string in the dictionary that can be formed by deleting some of the given string characters. If there is more than one possible result, return the longest word with the smallest lexicographical order. If there is no possible result, return the empty string.
 *
 *  
 *
 * Example 1:
 *
 * Input: s = "abpcplea", dictionary = ["ale","apple","monkey","plea"]
 * Output: "apple"
 * Example 2:
 *
 * Input: s = "abpcplea", dictionary = ["a","b","c"]
 * Output: "a"
 *  
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * 1 <= dictionary.length <= 1000
 * 1 <= dictionary[i].length <= 1000
 * s and dictionary[i] consist of lowercase English letters.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestWordInDictionaryThroughDeleting {

    public String findLongestWord(String s, List<String> dictionary) {
        if (s.length() == 0) {
            return "";
        }
        String[] strArr = dictionary.toArray(new String[dictionary.size()]);
        Arrays.sort(strArr, (str1, str2) -> {
            if(str1.length() < str2.length()) {
                return 1;
            } else if(str1.length() > str2.length()) {
                return -1;
            } else {
                return str1.compareTo(str2);
            }
        });
        for (String str : strArr) {
            if (isMatch(s, str)) {
                return str;
            }
        }
        return "";
    }
    public boolean isMatch(String s, String str) {
        int i = 0;
        int j = 0;
        int sLen = s.length();
        int strLen = str.length();
        while (i < sLen && j < strLen) {
            if (s.charAt(i) == str.charAt(j)) {
                i++;
                j++;
            } else {
                i++;
            }
        }
        if (j == strLen) {
            return true;
        }
        return false;
    }
}
