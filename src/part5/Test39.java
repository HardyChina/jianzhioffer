package part5;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 数组中出现次数超过一半的数字
 * @author 10592
 */
public class Test39 {
    /**
     * 暴力解法需要额外空间，O（n）
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution1(int [] array) {
        HashMap<Integer,Integer> map = new HashMap(array.length);
        int num;

        for (int i = 0; i < array.length; i++) {
            num = array[i];
            map.computeIfAbsent(num,x->{return 0;});
            map.put(num,map.get(num)+1);
            if (map.get(num)>array.length/2){
                return num;
            }
        }
        return 0;
    }

    /**
     * 先排序，在利用性质
     * @param array
     * @return
     */
    public static int MoreThanHalfNum_Solution2(int [] array) {
        Arrays.sort(array);
        int halfLength = array.length/2;
        for (int i = 0; i+halfLength < array.length; i++) {
            if (array[i] == array[i+halfLength]){
                return array[i];
            }
        }
        return 0;
    }
    public static int MoreThanHalfNum_Solution3(int [] array) {
        int length=array.length;

        int result=array[0];
        int times=1;
        for(int i=1;i<length;i++){
            if(times==0){
                result=array[i];
                times++;
            }else{
                if(array[i]==result){
                    times++;
                }else{
                    times--;
                }
            }
        }
        // 之所以有下边部分，是考虑到没有超过一半的情况，此时，result的值就不是出现最多元素的值了。

        times=0;
        for(int i=0;i<length;i++){
            if(result==array[i]){
                times++;
            }
        }

        if(times*2<=length){
            result=0;
        }
        return result;
    }


    public static void main(String[] args) {
        int[] array = {1,2,3,2,4,2,5,2,3};
//        System.out.println(MoreThanHalfNum_Solution1(array));
//        System.out.println(MoreThanHalfNum_Solution2(array));
        System.out.println(MoreThanHalfNum_Solution3(array));
    }
}
