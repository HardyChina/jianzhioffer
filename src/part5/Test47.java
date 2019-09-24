package part5;

/**
 * 礼物的最大价值,典型动态规划问题
 * @author 10592
 */
public class Test47 {
    public static int getMaxValueOfGift(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int[][] maxValue = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;

                if (i > 0){
                    up = maxValue[i - 1][j];
                }
                if (j > 0){
                    left = maxValue[i][j - 1];
                }
                maxValue[i][j] = Math.max(up, left) + arr[i][j];
            }
        }
        return maxValue[rows - 1][cols - 1];

    }

    /**
     * 对上一种方法的优化版本，使用一维数组代替了二维数组
     * @param arr
     * @return
     */
    public static int getMaxValueOfGift2(int[][] arr){
        int rows = arr.length;
        int cols = arr[0].length;
        int[] maxValue = new int[cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int up = 0;
                int left = 0;

                if (i > 0){
                    up = maxValue[j];
                }
                if (j>0){
                    left = maxValue[j-1];

                }
                maxValue[j] = Math.max(up, left) + arr[i][j];
            }
        }
        return maxValue[cols - 1];

    }

    public static void main(String[] args) {
        int[][] arr = {{1,10,3,8},{12,2,9,6},{5,7,4,11},{3,7,16,5}};
        System.out.println(getMaxValueOfGift(arr));
        System.out.println(getMaxValueOfGift2(arr));
    }

}
