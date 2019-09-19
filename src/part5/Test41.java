package part5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数
 * @author 10592
 */
public class Test41 {
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return -o1.compareTo(o2);
        }
    });
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    int size = 0;

    public void Insert(Integer num) {
        // 偶数放最小堆
        if (size % 2 == 0){
            if (!maxHeap.isEmpty()&& num < maxHeap.peek()){
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
            else {
                minHeap.offer(num);
            }
            size++;
        }
        // 偶数放入最大堆
        else{
            if (!minHeap.isEmpty() && num > minHeap.peek()){
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            else {
                maxHeap.offer(num);
            }
            size++;
        }


    }

    public Double GetMedian() {
        size = maxHeap.size() + minHeap.size();
        if (size % 2 == 0){
            return (double)(minHeap.peek()+maxHeap.peek())/2;
        }
        else {
            return maxHeap.size()>minHeap.size()? (double)maxHeap.peek():(double)minHeap.peek();
        }

    }

    public static void main(String[] args) {
        Test41 test = new Test41();
        test.Insert(1);
        test.Insert(2);
        test.Insert(3);
        test.Insert(4);
        test.Insert(5);
        System.out.println( test.GetMedian());
    }

}
