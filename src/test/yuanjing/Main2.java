package test.yuanjing;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
    static int[][] rect = null;

    public static void main(String[] args) {
        int m = 0;
        int n = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            int[] mn = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).toArray();
            m = mn[0];
            n = mn[1];
            
        }
    }
    public void count(){
    // 计数
    int count = 0;
    // 遍历矩阵找1,块的定位
    for (int i = 0; i < rect.length; i++) {
        for (int j = 0; j < rect[i].length; j++) {
            // 当找到1时,开始处理其所在的块
            if (rect[i][j] == 1) {
                block(i, j);
                count++;
            }
        }
    }
    // 输出块数
    System.out.println("该矩阵中,共有" + count + "块");

}
    // 判断连续块,递归
    private static void block(int i, int j) {
        // 修改(i,j)坐标对应的数组元素的值(避免递归时反复判断相邻元素)
        rect[i][j] = 4;
        // 分别判断上下左右
        if (i < rect.length - 1 && rect[i + 1][j] == 1) {
            block(i + 1, j);
        }
        if (i > 0 && rect[i - 1][j] == 1) {
            block(i - 1, j);
        }
        if (j < rect[i].length - 1 && rect[i][j + 1] == 1) {
            block(i, j + 1);
        }
        if (j > 0 && rect[i][j - 1] == 1) {
            block(i, j - 1);
        }
    }

}
