package part3;

/**
 * 打印从1到最大的n位数
 * @author 李震寰
 */
public class Test17 {
    public static void print1ToMaxOfDigits(int n){
        if (n <= 0){
            return;
        }
        //arr表示一个数
        int[] arr = new int[n];
        while (!increment(arr)){
            printNumber(arr);
        }


    }

    /**
     * 模拟实现加法，逢十进一
     * @param arr
     * @return
     */
    private static boolean increment( int[] arr){
        //位数
        boolean finished = false;
        int nTakeOver = 0;
        // 每循环一次，i所在的位数进行一次加1运算，每次都从第一位加起
        for (int i = arr.length - 1; i >= 0; i--) {
            int sum = arr[i] + nTakeOver;
            if (i == arr.length-1){
                sum++;
            }
            if (sum >= 10){
                if (i == 0){
                    finished = true;
                }
                else {
                    sum -= 10;
                    nTakeOver = 1;
                    arr[i] = sum;
                }
            }
            else {
                arr[i] = sum;
                break;
            }

        }
        return finished;

    }

    /**
     * 打印数组arr
     * @param arr
     */
    private static void printNumber(int[] arr){
        // 找第一个非0的元素
        int index = 0;
        while (index < arr.length && arr[index] == 0) {
            index++;
        }

        // 从第一个非0值到开始输出到最后的元素。
        for (int i = index; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        // 条件成立说明数组中有非零元素，所以需要换行
        if (index < arr.length) {
            System.out.println();
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfDigits(32);
    }


}
