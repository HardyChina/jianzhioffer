package test.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author 10592
 */
public class SelectionSort {
    public static void sort(int[] array){
        for (int i = 0; i < array.length; i++) {
            int min =i;
            for (int j = i; j < array.length; j++) {
                if (array[j] < array[min]){
                    min = j;
                }
            }
            if (min != i){
                int tem = array[i];
                array[i] = array[min];
                array[min] = tem;
            }

        }
    }
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};
        sort(array);
        Arrays.stream(array).forEach(System.out::print);
    }
}
