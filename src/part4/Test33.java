package part4;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * @author lzh
 */
public class Test33 {
    public static boolean verifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0){
            return false;
        }
        int root = sequence[sequence.length - 1];
        int i = 0;
        // 左子树的节点都小于root，注意length - 1，因为不包括root
        for (; i < sequence.length - 1; i++) {
            if (sequence[i] > root){
                break;
            }
        }
        int j = i;
        // 遍历右子树
        for (;j < sequence.length - 1; j++){
            if (sequence[j] < root){
                return false;
            }
        }
        boolean left = true;
        // 如果存在左子树
        if (i > 0){
            int[] subSequence = new int[i];
            System.arraycopy(sequence,0,subSequence,0,i);
            left = verifySquenceOfBST(subSequence);
        }
        boolean right = true;
        if (i < sequence.length -1){
            int[] subSequence = new int[sequence.length - i - 1];
            System.arraycopy(sequence,i,subSequence,0,sequence.length - i - 1);
            right = verifySquenceOfBST(subSequence);

        }
        return left && right;

    }

    /**
     * 非递归实现
     * @param sequence
     * @return
     */
    public static boolean verifySquenceOfBST2(int [] sequence) {
        int size = sequence.length;
        int i = 0;

        while (--size > 0){
            while (sequence[i++] < sequence[size]){};
            while (i<size&&sequence[i++]>sequence[size] ){};
            if (i<size){return false;}
            i = 0;
        }
        return true;

    }
    public static void main(String[] args) {
        int[] sequence1 = {5, 7, 6, 9, 11, 10 ,8};
        int[] sequence2 = {1,2,3,4,5};
        System.out.println(verifySquenceOfBST(sequence1));
        System.out.println(verifySquenceOfBST2(sequence1));
        System.out.println(verifySquenceOfBST(sequence2));
        System.out.println(verifySquenceOfBST2(sequence2));

    }
}
