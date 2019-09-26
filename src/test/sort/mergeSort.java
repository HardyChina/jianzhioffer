package test.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author 10592
 */
public class mergeSort {
    public static int[] sort(int[] array){
        // 长度为1 默认有序，开始归并
        if (array.length < 2){
            return array;
        }
        int midele = (int)Math.floor(array.length / 2);
        int[] left = Arrays.copyOfRange(array,0,midele);
        int[] right =Arrays.copyOfRange(array,midele,array.length);
        // 归并过程
        return merge(sort(left),sort(right));
    }
    /**
     * 归并过程函数
     * @param left
     * @param right
     * @return
     */
    public static int[] merge(int[] left, int[] right){
        int i = 0;
        // 空间复杂度为O(n)
        int[] reslut = new int[left.length + right.length];
        // 归并第一步，左小于右将左的放入数组并将左数组下标右移一位，反之一样。
        while (left.length > 0 && right.length >0){
            if (left[0] <= right[0]){
                reslut[i++] = left[0];
                left = Arrays.copyOfRange(left,1,left.length);
            }
            else {
                reslut[i++] = right[0];
                right = Arrays.copyOfRange(right,1, right.length);

            }
        }
        // 完成上一步后，将剩下的数字全部放入result中，以下两个循环只会执行一个。
        while (left.length > 0){
            reslut[i++] = left[0];
            left = Arrays.copyOfRange(left,1,left.length);

        }
        while (right.length > 0){
            reslut[i++] = right[0];
            right = Arrays.copyOfRange(right,1,right.length);
        }
        return reslut;
    }

    /**
     * 归并排序的非递归实现
     * @param array
     * @return
     */
    public static int[] sort1(int[] array){
        for (int i = 1; i < array.length; i = i*2) {
            for (int j = 0; j < array.length - i; j += i * 2) {
                merge1(array,j,j+i-1,j+i*2-1);
            }
        }
        return array;
    }
    public static void merge1(int[] array, int left, int mid, int right){
        int i = left;
        int j = mid;
        int t = 0;
        int[] result = Arrays.copyOfRange(array,left,right+1);
        for (; i < mid && j < right + 1;t++ ) {
            if (result[i] <= result[j] ){
                array[i] = result[i];
                i++;
            }
            if (result[i] > result[j]){
                array[i] = result[j];
                j++;
            }
        }
        while (i < mid){
            array[t] =  result[i++];
        }
        while (j < right +1){
            array[t] = result[j++];

        }

    }


    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};

        Arrays.stream(sort1(array)).forEach(System.out::print);
    }

}
