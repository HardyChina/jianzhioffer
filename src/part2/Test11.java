package part2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author 李震寰
 * 旋转数组中最小的数字
 */
public class Test11 {
    public static int min(int[] data){
        if (data == null){
            throw new RuntimeException("null");
        }
        int index1 = 0;
        int index2 = data.length - 1;
        int midIndex = index1;
        while (data[index1] >= data[index2]){
            if (index2 - index1 == 1){
                midIndex = index2;
                break;
            }
            midIndex = (index1 + index2) / 2;
            if (data[index1] == data[index2] && data[index1] == data[midIndex]){
                return minOrder(data);
            }
            if (data[midIndex] >= data[index1]){
                index1 = midIndex;
            }
            else if (data[midIndex] <= data[index2]){
                index2 = midIndex;
            }
        }
        return data[midIndex];
    }

    /**
     * 使用顺序查找的办法找到最小数字
     * @param data
     * @return
     */
    public static int minOrder(int[] data){
        // Arrays.stream(data)返回一个IntStream对象，boxed将int转为Ineger，collect通过Collectors，将stream转换为list对象
        List<Integer> list = Arrays.stream(data).boxed().collect(Collectors.toList());
        IntSummaryStatistics statistics = list.stream().mapToInt(x->x).summaryStatistics();
        return statistics.getMin();
    }

    public static void main(String[] args) {
        int[] data = {3, 4 ,5, 1, 2};
        int[] data1 = {1, 0 ,1, 1, 1};
        System.out.println(min(data));
        System.out.println(min(data1));
    }
}
