package Algorithms;

import java.util.LinkedList;
import java.util.Stack;

/**
 * 2.有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * 有效字符串需满足：
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * 示例 1:
 * 输入: "()" 输出: true
 * 示例 2:
 * 输入: "()[]{}" 输出: true
 * 示例 3:
 * 输入: "(]" 输出: false
 * 示例 4:
 * 输入: "([)]" 输出: false
 * 示例 5:
 * 输入: "{[]}" 输出: true
 */
public class ValidParentheses {

    public boolean isValid(String s) {
        Stack stack = new Stack<Character>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            switch (s.charAt(i)) {
                case '(':
                    stack.push('('); break;
                case '[':
                    stack.push('['); break;
                case '{':
                    stack.push('{'); break;
                case ')':
                    if (!stack.empty()) {
                        if (stack.peek().equals('(') ) {
                            stack.pop();
                        } else {
                            stack.push(')');
                        }
                    } else {
                        stack.push(')');
                    }
                    break;
                case ']':
                    if (!stack.empty()) {
                        if (stack.peek().equals('[') ) {
                            stack.pop();
                        } else {
                            stack.push(']');
                        }
                    } else {
                        stack.push(']');
                    }
                    break;
                case '}':
                    if (!stack.empty()) {
                        if (stack.peek().equals('{') ) {
                            stack.pop();
                        } else {
                            stack.push('}');
                        }
                    } else {
                        stack.push('}');
                    }
                    break;
            }

        }
        if (stack.isEmpty()) return true;
        else return false;
    }
}
