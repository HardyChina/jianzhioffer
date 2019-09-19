package part5;

/**
 * 连续子数组的最大和
 * @author 10592
 */
public class Test42 {
    public static int FindGreatestSumOfSubArray(int[] array) {
        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < array.length; i++) {
            // 如果序列和为0，不如不加，从当前点作为起点重新开始，由于已经验证了之前点作为起点不可行，因此丛当前接地开始即可
            if (sum <= 0){
                sum = array[i];
            }
            else {
                sum += array[i];
            }
            if (sum > maxSum){
                maxSum = sum;
            }
        }
        return maxSum;

    }

    /**
     * 动态规划,以i为结尾的最大子序列
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray2(int[] array) {
        int res = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            max = Math.max(max + array[i],array[i]);
            res = Math.max(res,max);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] array = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(array));
        System.out.println(FindGreatestSumOfSubArray2(array));
    }
}
