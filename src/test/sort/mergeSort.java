package test.sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author 10592
 */
public class mergeSort {
    public static int[] sort(int[] array){
        if (array.length < 2){
            return array;
        }
        int midele = (int)Math.floor(array.length / 2);
        int[] left = Arrays.copyOfRange(array,0,midele);
        int[] right =Arrays.copyOfRange(array,midele,array.length);

        return merge(sort(left),sort(right));
    }
    public static int[] merge(int[] left, int[] right){
        int i = 0;
        int[] reslut = new int[left.length + right.length];
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
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};

        Arrays.stream(sort(array)).forEach(System.out::print);
    }

}
