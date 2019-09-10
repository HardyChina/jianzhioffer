package test.sort;

import java.util.Arrays;

/**
 * 希尔排序，增量随便选择，只要最后的1即可
 * @author 10592
 */
public class shellSort {
    public static void sort(int[] arr){
        int gap = 1;
        while(gap < arr.length/3){
            gap = gap * 3 + 1;
        }

        while (gap > 0){
            for (int i = gap; i < arr.length; i++) {
                int tem = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tem){
                    arr[j+ gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tem;
            }
            gap = (int) Math.floor(gap / 3);
        }


    }

    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};
        sort(array);
        Arrays.stream(array).forEach(System.out::print);
    }
}
