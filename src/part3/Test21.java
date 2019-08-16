package part3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author  李震寰
 * 调整数组顺序使奇数位于偶数前边
 */
public class Test21 {
    /**
     * 自己写的比较朴素的解法
     * @param array
     */
    public static void reOrderArray(int [] array) {
        if (array == null || array.length ==0){
            return;
        }
        int[] list = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 != 0){
               list[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 2 == 0) {
                list[index++] = array[i];
            }
        }
        System.arraycopy(list, 0, array,0, array.length);

    }

    /**
     * 剑指offer的实现方法，注意可以使用策略魔兽扩展判断条件,但奇数和偶数的相对位置会改变
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        if (array == null || array.length ==0){
            return;
        }
        // 建立两个指向数组头尾的指针
        int pre = 0;
        int end = array.length - 1;
        while (pre < end){
            while (array[pre] % 2 != 0){
                pre++;
            }
            while (array[end] % 2 == 0){
                end--;
            }
            if (pre < end){
                array[pre] ^= array[end];
                array[end] ^= array[pre];
                array[pre] ^= array[end];
            }
        }
    }

    /**
     * 奇偶数相对位置不会改变
     * @param array
     */
    public static void reOrderArray3(int [] array) {
        if (array == null || array.length ==0){
            return;
        }
        // 想要变为有序指针方向需要一致
        int i = 0;
        int j = 0;
        while (i <array.length){
            // 找偶数
            while (i < array.length && array[i] % 2 != 0){
                i++;
            }
            j = i + 1;
            // 找奇数
            while (j < array.length && array[j] % 2 == 0){
                j++;
            }
            if (j < array.length){
                int tem = array[j];
                for (int z = j -1 ;z >= i;z--){
                    array[z + 1] = array[z];
                }
                array[i] = tem;
            }
            else {
                break;
            }

        }

    }

    /**
     * 借鉴冒泡
     * @param array
     */
    public static void reOrderArray4(int [] array){
        if (array == null || array.length ==0){
            return;
        }
        int m = array.length;
        // 记录奇数的个数
        int k = 0;
        for (int i = 0; i < m; i++) {
            // 发现奇数后采用冒泡的方式放到合适的位置，保证稳定性
            if (array[i] % 2 != 0){
                int j = i;
                while (j > k){
                    array[j] ^= array[j - 1];
                    array[j -1] ^= array[j];
                    array[j] ^= array[j - 1];
                    j--;
                }
                k++;

            }
        }

    }
    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5,6,7};
        int[] array2 = {1,2,3,4,5,6,7};
        int[] array3 = {1,2,3,4,5,6,7};
        reOrderArray(array1);
        // reOrderArray2(array);
        reOrderArray3(array2);
        Arrays.stream(array1).boxed().forEach(System.out::print);
        System.out.println();
        Arrays.stream(array2).boxed().forEach(System.out::print);
        reOrderArray4(array3);
        System.out.println();
        Arrays.stream(array3).boxed().forEach(System.out::print);
    }
}
