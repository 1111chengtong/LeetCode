package Algorithms;

/**
 * You are given an array of strings words and a string chars.
 *
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 *
 * Return the sum of lengths of all good strings in words.
 *
 *  
 *
 * Example 1:
 *
 * Input: words = ["cat","bt","hat","tree"], chars = "atach"
 * Output: 6
 * Explanation:
 * The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
 * Example 2:
 *
 * Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
 * Output: 10
 * Explanation:
 * The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 *  
 *
 * Note:
 *
 * 1 <= words.length <= 1000
 * 1 <= words[i].length, chars.length <= 100
 * All strings contain lowercase English letters only.
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-words-that-can-be-formed-by-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindWordsThatCanBeFormedByCharacters {
    public int countCharacters(String[] words, String chars) {
        int[][] characters = new int[26][2];
        int charsLen = chars.length();
        int wordsLen = words.length;
        int totalLen = 0;
        for (int i = 0; i < charsLen; i++) {
            char ch = chars.charAt(i);
            characters[ch - 'a'][0]++;
        }
        outer: for (int i = 0; i < wordsLen; i++) {
            for (int k = 0; k < 26; k++) {
                characters[k][1] = characters[k][0];
            }
            String word = words[i];
            for (int j = 0; j < word.length(); j++) {
                char ch2 = word.charAt(j);
                characters[ch2 - 'a'][1]--;
                if (characters[ch2 - 'a'][1] < 0) {
                    continue outer;
                }
            }
            totalLen += word.length();
        }
        return totalLen;
    }
}
