package part2;

/**
 * @author 李震寰
 * 剑指offer第三题，数组中重复的数字
 */
public class Test3 {
    /**
     *题目1 找出数组中的重复数字
     * @param numbers 在操作的数组
     * @param len 数组长度
     * @return 是否含有重复的数字
     */
    public boolean duplicate(int numbers[],int len){
        if (numbers == null||len <=0){
            return false;
        }
        for (int a: numbers
             ) {
            if (a <0 || a>= len){
                return false;
            }
        }
        for (int i = 0; i < len ; i++) {
            if (numbers[i] == i){
                continue;
            }
            else if (numbers[i] != i){
                if (numbers[numbers[i]] == numbers[i]){
                    System.out.println("含有重复数字"+numbers[i]);
                    return true;
                }
                else {
                    //交换值
                    numbers[i] ^= numbers[numbers[i]];
                    numbers[numbers[i]] ^= numbers[i];
                    numbers[i] ^=  numbers[numbers[i]];
                }
            }
        }
        return false;

    }

    /**
     * 3.2 不修改数组找出重复数字
     * @param numbers
     * @param len
     */
    public boolean duplicateNotChangeArray(int[] numbers,int len){
        if (numbers == null||len <=0){
            return false;
        }
        int start = 1;
        int end = len -1;
        while (start <= end){
            int middle =( (end - start) >> 1) + 1;
            int count = countRange(numbers,len, start,middle);
            if (start == end){
                if (count > 1){
                    System.out.println("含有重复数字"+ start);
                    return true;
                }
                else {
                    break;
                }
            }
            if (count > ( middle - start + 1)){end = middle;}
            else {start = middle +1;}
        }

        return false;
    }

    /**
     * 题目2 的辅助函数，返回在某一范围内的个数
     * @param numbers
     * @param len
     * @param start
     * @param end
     * @return
     */
    public int countRange(int[] numbers, int len ,int start, int end){
        if (numbers == null || len <=0){return -1;}
        int count = 0;
        for (int i = 0;i < len ;i++){
            if (numbers[i] >= start && numbers[i] <= end){count++;}
        }
        return count;
    }
    public static void main(String[] args){
        int[] numbers = new int[]{1,1,2,3,4,5,6,7,8,9};
        int[] numbers1 = new int[]{1,2,3,4,5,6,7,8,9};
        int[] numbers2 = new int[]{};

        Test3 test3 = new Test3();
        test3.duplicate(numbers,numbers.length);
        test3.duplicate(numbers1,numbers1.length);
        test3.duplicate(numbers2,numbers2.length);

        test3.duplicateNotChangeArray(numbers,numbers.length);

    }
}
