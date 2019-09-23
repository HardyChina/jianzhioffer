package part5;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *把数组排成最小的数
 * @author 10592
 */
public class Test45 {
    /**
     * 通过重写排序规则实现，比较简单
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        List<Integer> list = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                String str1 = String.valueOf(o1) + String.valueOf(o2);
                String str2 = String.valueOf(o2) + String.valueOf(o1);
                return Integer.compare(Integer.valueOf(str1),Integer.valueOf(str2));
            }
        });
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            stringBuilder.append(list.get(i));
        }
        return stringBuilder.toString();

    }

    public static void main(String[] args) {
        int[] arr = {3,32,321};
        System.out.println(PrintMinNumber(arr));
    }
}
