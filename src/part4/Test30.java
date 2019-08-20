package part4;

import java.util.Stack;

/**
 * 应用一个辅助栈，压的时候，如果A栈的压入比B栈压入大，B栈不压，，，，小于等于，AB栈同时压入，出栈，如果，AB栈顶元素不等，A出，B不出。
 * @author lzh
 */
public class Test30 {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public void push(int node) {
       if (minStack.isEmpty()){
           minStack.push(node);
       }
       mainStack.push(node);
       if (node <= minStack.peek()){
           minStack.push(node);
       }
    }

    public void pop() {
       if (mainStack.peek() .equals(minStack.peek()) ){
           minStack.pop();
       }
       mainStack.pop();

    }
    public int top() {
        return mainStack.peek();

    }

    public int min() {
        return minStack.peek();

    }
}
