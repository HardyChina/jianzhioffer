package test;


/**
 * @author 李震寰
 */
public class QuickSort {
    public static void quickSort(int[] data, int length, int start, int end){
        if (start == end){
            return;
        }
        int index = partition(data , length, start ,end);
        if (index > start){
            quickSort(data, length, start, index-1);
        }
        if (index <end){
            quickSort(data, length, index+1, end);
        }

    }

    /**
     * 剑指offer中快速排序的实现
     * 在数组中选择一个数字，将比该数字小的放在左边，比该数字大的放在右边
     * @param data
     * @param length
     * @param start
     * @param end
     * @return
     */
    public static int partition(int[] data, int length, int start, int end){
        if (data == null || length <= 0 || start < 0 || end >= length){
            throw new RuntimeException("error");
        }
        //选择第一个数字作为要比较的数字
        int index = start;
        //small表示比选中数字小的部分
        int small = index - 1;
        //先将选中的数字放在数组末尾
        swap(data, index ,end);

        for ( ; index < end; index++) {
            if (data[index] < data[end]){
                small++;
                if (data[small] != data[index]){
                    swap(data, small, index);
                }
                else {
                    //System.out.println(data[end]);
                    System.out.println("small"+small);
                    System.out.println(data[small]);
                    System.out.println("index"+index);
                }
            }
        }
        //将原本在end位置上的被选中点回到正确的位置
        small++;
        swap(data, small, end);
        return small;

    }

    /**
     * 交换数组中两个元素的位置
     * @param data
     * @param index1
     * @param index2
     */
    public static void swap(int[] data, int index1, int index2){
        int tem = data[index1];
        data[index1] = data[index2];
        data[index2] = tem;
    }

    public static void main(String[] args) {
        int[] data = {1,5,3,2,4,3,7,9,4};
        quickSort(data, data.length, 0, data.length-1);
        for (int i:
             data) {
            System.out.print(i);

        }

    }



}
