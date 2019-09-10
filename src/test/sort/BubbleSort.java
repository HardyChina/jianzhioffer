package test.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * @author 10592
 */
public class BubbleSort {
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            // 信号量，当执行完一趟冒泡没有发生交换时，即前后两个元素都是有序的，此时停止循环
            boolean flag = true;
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j + 1]){
                    int tem = array[j];
                     array[j] = array[j+1];
                     array[j+1] = tem;
                     flag = false;
                }

            }
            if (flag){
                break;
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};
        sort(array);
        Arrays.stream(array).forEach(System.out::print);
    }

}
