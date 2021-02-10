package Algorithms;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SortCharactersByFrequency {

    public static String frequencySort(String s) {
        int[] frequency = new int[128];
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            frequency[ch]++;
        }
        // 大顶堆
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] a1, int[] a2) {
                return a2[0] - a1[0];
            }
        });
        // 若频率大于0，则将频率和字母对应的下标加入到优先队列
        for (int i = 0; i < 128; i++) {
            if (frequency[i] > 0) {
                pq.offer(new int[]{frequency[i], i});
            }
        }
        StringBuffer ret = new StringBuffer();
        while (!pq.isEmpty()) {
            int[] arr = pq.poll();
            for (int i = 0; i < arr[0]; i++) {
                ret.append((char)(arr[1]));
            }
        }
        return ret.toString();
    }

    public static void main(String[] args) {
        String str = frequencySort("tree");
        System.out.println(str);
    }
}
