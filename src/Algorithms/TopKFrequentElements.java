package Algorithms;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 *
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 *
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * It's guaranteed that the answer is unique, in other words the set of the top k frequent elements is unique.
 * You can return the answer in any order.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/top-k-frequent-elements
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {
        //map中的key为数组nums中出现的数字，value为其频率
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry> pq = new PriorityQueue<Map.Entry>(new Comparator<Map.Entry>() {
            public int compare(Map.Entry e1, Map.Entry e2) {
                return (int)e1.getValue() - (int)e2.getValue();
            }
        });
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.offer(entry);
            } else {
                // 优先队列pq的size已达到k
                if ((int)entry.getValue() - (int)pq.peek().getValue() > 0 ) {
                    pq.poll();
                    pq.offer(entry);
                }
            }
        }
        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = (int)pq.poll().getKey();
        }
        return result;
    }
}
