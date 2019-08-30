package test.sort;

import java.util.Arrays;

/**
 * 快速排序,每次对一个基数按照大小分成两个数组，在对这两个数组进行递归
 * @author lzh
 */
public class QuickSort {
    public static void quickSort(int[] data, int length, int start, int end){
        if (start >= end) {
            return;
        }
        int index = partition(data,data.length,start,end);
        if (index > start){
            quickSort(data,length,start,index - 1);
        }
        if (index < end){
             quickSort(data,length,index + 1,end);
        }


    }

    /**
     * 将数组分成大于基数，小于基数的两部分，返回基数的下标
     * @param data
     * @param length
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] data, int length, int start, int end){
        int index = start;
        int small = index - 1;
        swap(data,index,end);
        for (; index < end; index++) {
           if (data[index] < data [end]) {
               small++;
               // 提高性能，减少交换，注意index++的时机是完成本次循环后
               if (small != index) {
                   swap(data,small,index);
               }
           }
        }
        small++;
        swap(data,small,end);
        return small;
    }
    public static void swap(int[] data, int index1, int index2){
       int tem = data[index1];
       data[index1] = data[index2];
       data[index2] = tem;
    }
    public static void main(String[] args) {
        int[] data = {1,5,3,2,4,3,7,9,4};
        quickSort(data, data.length, 0, data.length - 1);
        Arrays.stream(data).forEach(System.out::print);
    }


}
