package part5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.in;


/**
 * topK
 * @author 10592
 */
public class Test40 {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> list = new ArrayList<>();
        if (k > input.length){
            return list;
        }
        if (input == null || k == 0){
            return list;
        }
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                partition(input, start, end);

            } else {
                start = index + 1;
                partition(input, start, end);

            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;

    }
    public  static int partition(int[] input,int start, int end){
        int index = start;
        int small = index - 1;
        swap(input,index,end);

        for (; index < end; index++) {
            if (input[index] < input[end]){
                small++;
                if (input[small] != input[index]){
                    swap(input, small, index);
                }
            }

        }
        small++;
        swap(input,end,small);
        return  small;

    }
    public static void swap(int[] data, int index1, int index2){
        int tem = data[index1];
        data[index1] = data[index2];
        data[index2] = tem;
    }
    public static ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || k > input.length){
            return list;
        }
        Arrays.sort(input);

        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    /**
     * 使用最大堆解决问题
     * @param input
     * @param k
     * @return
     */
    public static ArrayList<Integer> GetLeastNumbers_Solution3(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>(k);
        if (k > input.length){
            return list;
        }
        if (input == null || k == 0){
            return list;
        }
        // 默认自然序列，为小顶堆，因此需要重写compare方法，实现大顶堆
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2){
                return -o1.compareTo(o2);
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (maxHeap.size() < k){
                maxHeap.add(input[i]);
            }
            else {
                if (maxHeap.peek() > input[i]){
                    maxHeap.poll();
                    maxHeap.add(input[i]);
                }
            }
        }
        for (Integer i :
                maxHeap) {
            list.add(i);
        }
        return list;
    }

    public static void main(String[] args) {
       int[] input = {4,5,1,6,2,7,3,8};
       long start =  System.currentTimeMillis();
        GetLeastNumbers_Solution(input, 4).stream().forEach(System.out::print);
        long end1 = System.currentTimeMillis();
        System.out.println();
        System.out.println(end1 - start);
        GetLeastNumbers_Solution2(input,4).stream().forEach(System.out::print);
        long end2 = System.currentTimeMillis();
        System.out.println();
        System.out.println(end1 - end2);
        GetLeastNumbers_Solution3(input,4).stream().forEach(System.out::print);


    }
}
