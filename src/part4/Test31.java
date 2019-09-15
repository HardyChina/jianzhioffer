package part4;
import java.util.Stack;


/**
 * @author lzh
 */
public class Test31 {

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length == 0 || popA.length == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int popIndex = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);
            while (!stack.isEmpty() && stack.peek() == popA[popIndex]){
                stack.pop();
                popIndex++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] push = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        System.out.println(IsPopOrder(push , pop1));
    }
}

