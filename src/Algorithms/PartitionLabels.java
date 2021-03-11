package Algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * A string S of lowercase English letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.
 *
 *  
 *
 * Example 1:
 *
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 *  
 *
 * Note:
 *
 * S will have length in range [1, 500].
 * S will consist of lowercase English letters ('a' to 'z') only.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/partition-labels
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PartitionLabels {

    public List<Integer> partitionLabels(String S) {
        int last[] = new int[26];
        int len = S.length();
        for (int i = 0; i < len; i++) {
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> list = new ArrayList<>();
        int start = 0;
        int end = 0;
        for (int i = 0; i < len; i++) {
            end = Math.max(end, last[S.charAt(i) - 'a']);
            if (i == end) {
                list.add(end - start + 1);
                start = end + 1;
            }
        }
        return list;
    }
}
