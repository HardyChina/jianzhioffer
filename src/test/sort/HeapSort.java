package test.sort;

import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * 堆排序
 * 1.构造最大堆
 * 2.此时堆顶元素为最大元素，将其同数组最后元素互换位置，数组长度-1，在调整最大堆，从剩下元素中找到最大元素，一次类推。
 * @author 10592
 */
public class HeapSort {
    public static int[] sort(int[] sourceArray) {
        int len = sourceArray.length;
        buildMaxHeap(sourceArray,len);
        Arrays.stream(sourceArray).forEach(System.out::print);
        System.out.println();
        for (int i = len - 1; i > 0; i--) {
            swap(sourceArray, 0 , i);
            len--;
            heapify(sourceArray,0,len);

        }
         return sourceArray;

    }
    private static void buildMaxHeap(int[] arr, int len) {
        for (int i = (int)Math.floor(len / 2); i >= 0; i--) {
            heapify(arr,i,len);

        }
    }
    private static void heapify(int[] arr, int i, int len) {
        int largest = i;
        int left = 2 * i +1;
        int right = 2 * i + 2;

        if (left< len && arr[largest] < arr[left]){
            largest = left;
        }
        if (right < len && arr[largest] < arr[right]){
            largest = right;
        }
        if (largest!=i){
            swap(arr,largest,i);
            heapify(arr,largest,len);
        }
    }
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void main(String[] args) {
        int[] array = {3,1,2,4,5,8,7,6,5,7};

        Arrays.stream(sort(array)).forEach(System.out::print);
    }
}
