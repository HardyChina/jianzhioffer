package test.sort;

import java.util.Arrays;

public class InsertSort {
    public static void sort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int tem = array[i];
            int j = i;
            // 确定位置，给插入挪出地方来
            while (j > 0 && tem < array[j - 1]){
                array[j] = array[j - 1];
                j--;
            }
            if (j != i){
                array[j] = tem;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};
        sort(array);
        Arrays.stream(array).forEach(System.out::print);
    }
}
