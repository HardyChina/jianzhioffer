package part4;

import java.util.ArrayList;
import java.util.List;

/**
 * 顺时针打印矩阵
 * @author lzh
 */
public class Test29 {
    /**
     * 每次打印一圈，打印一圈后在打印里边的一圈，因此问题的关键是如何判断完成一圈。以及下一圈的起点。
     * @param matrix
     * @return
     */
    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix == null) {
            return null;
        }
        ArrayList<Integer> list = new ArrayList<>();
        int rows = matrix.length;
        int cols = matrix[0].length;
        int start = 0;
        while (rows > start * 2 && cols > start *2){
            printCyle(matrix,start,list);
            start++;
        }
        return list;
    }


    public static void printCyle(int[][] matrix,int start, ArrayList<Integer> list ){
        int endRow = matrix.length - start- 1;
        int endCol = matrix[0].length - start  - 1;
        
        // 从左向右打印一行
        for (int i = start; i <= endCol; i++) {
            list.add(matrix[start][i]);
        }
        //  在从上到下
        if (start < endRow){
            for (int i = start + 1; i <= endRow ; i++) {
                list.add(matrix[i][endCol]);
            }
        }
        // 从右往左
        if (start < endRow && start < endCol){
            for (int i = endCol -1 ; i >= start; i--) {
                list.add(matrix[endRow][i]);
            }
        }
        // 从下往下
        if (start < endCol && start <endRow - 1){
            for (int i = endRow -1; i> start ; i--) {
                list.add(matrix[i][start]);

            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
        int[][] mmatrix2 = {{1}};
        int[][] matrix3 = {{1,2},{3,4}};
        int[][] matrix4 = {{1},{2},{3},{4},{5}};
//        printMatrix(matrix3).forEach(System.out::print);
//        System.out.println();
//        printMatrix(mmatrix2).forEach(System.out::println);
//        ArrayList<Integer> list = printMatrix(matrix);
//        list.forEach(System.out::print);
        printMatrix(matrix4).forEach(System.out::print);

    }
}
