package part2;

import java.util.Stack;

/**
 * 使用两个栈实现一个队列
 * @author 10592
 */
public class Test7 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);

    }

    public int pop() {
        int popNum = 0;
        //1.通过两个栈来实现先进先出
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        popNum = stack2.pop();

        //2.在将stack2中其他的的数据导入stack1为下次pop准备
//        while (!stack2.isEmpty()){
//            stack1.push(stack2.pop());
//        }
        return popNum;
    }

    public static void main(String[] args) {
        Test7 test7 = new Test7();
        test7.push(1);
        test7.push(2);
        test7.push(3);
        System.out.println(test7.pop());
        System.out.println(test7.pop());
        test7.push(4);
        System.out.println(test7.pop());
        test7.push(5);
        System.out.println(test7.pop());
        System.out.println(test7.pop());


    }
}
