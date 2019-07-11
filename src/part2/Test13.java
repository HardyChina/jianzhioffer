package part2;

/**
 * 机器人的运动范围
 * @author 李震寰
 */
public class Test13 {
    /**
     * 机器人运动范围主函数
     * @param threshold k值
     * @param rows
     * @param cols
     * @return
     */
   public int movingCount(int threshold, int rows, int cols){
       // 验证
       if (threshold < 0 || rows < 1|| cols < 1 ){
           return 0;
       }
       // 初始化visited矩阵
       boolean[] visited = new boolean[rows * cols];
       for (int i = 0; i < visited.length; i++) {
           visited[i] = false;
       }
       //调用movingCountCore方法实现回溯过程
       return  movingCountCore(threshold, rows, cols, 0, 0, visited);


   }

    /**
     * 机器人运动范围回溯的实现
     * @param threshold
     * @param rows
     * @param cols
     * @param row
     * @param col
     * @param visited
     * @return
     */
   public int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[] visited){
       int count = 0;
       if (check(threshold,rows, cols, row, col, visited)){
           visited [cols * row + col] = true;
           count = 1 +
           movingCountCore(threshold, rows, cols, row, col+1, visited)+
           movingCountCore(threshold, rows, cols, row, col-1, visited)+
           movingCountCore(threshold, rows, cols, row+1, col, visited)+
           movingCountCore(threshold, rows, cols, row-1, col, visited);
       }
       return  count;
   }

    /**
     * 判断某个节点是否可以进入
     * @param threshold
     * @param row
     * @param col
     * @param visited
     * @return
     */
   public boolean check(int threshold, int rows, int cols,int row, int col, boolean[] visited){
       if (row >= 0 && row < rows && col < cols && col >= 0&& getDigiSum(col) + getDigiSum(row) <= threshold && !visited[row * cols + col]){
           return true;
       }
       return false;
   }

    /**
     * 得到数位和
     * @param number
     * @return
     */
   public int getDigiSum(int number){
       int sum = 0;
       while (number > 0){
           sum += number % 10;
           number /= 10;
       }
       return sum;
   }

    public static void main(String[] args) {
        Test13 test13 = new Test13();
        int count =  test13.movingCount(5, 10, 10);
        System.out.println(count);
    }
}
