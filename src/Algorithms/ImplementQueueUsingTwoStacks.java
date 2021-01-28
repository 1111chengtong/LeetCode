package Algorithms;

import java.util.Stack;

/**
 * 4.用两个栈实现队列
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 */
public class ImplementQueueUsingTwoStacks {
    Stack st1;
    Stack st2;

    public ImplementQueueUsingTwoStacks() {
        st1 = new Stack<Integer>();
        st2 = new Stack<Integer>();
    }

    public void appendTail(int value) {
        while (!st1.isEmpty()) {
            st2.push(st1.pop());
        }
        st1.push(value);
        while (!st2.isEmpty()) {
            st1.push(st2.pop());
        }
    }

    public int deleteHead() {
        if(!st1.isEmpty()) {
            return (int)st1.pop();
        }
        return -1;
    }
}
