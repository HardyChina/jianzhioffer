package part2;

import org.junit.Test;

/**
 * 数组中查找
 * @author 李震寰
 */
public class Test4 {
    /**
     * 在matrix中寻找target
     * @param matrix
     * @param target
     */
    public boolean find(int[][] matrix,int target){
        boolean found = false;
        int rows = matrix.length;
        int columns = matrix[0].length;

        if (matrix != null && rows>0 && columns>0){
            int row = 0;
            int column = columns - 1;
            while (row < rows && row>= 0&& column<columns && column>= 0){
                if (matrix[row][column] == target){
                    System.out.println("Find target");
                    found = true;
                    break;
                }
                else if (matrix[row][column] > target){
                    column--;
                }
                else {
                    row++;
                }
            }
        }

        return found;

    }
    public  static void main(String[] args){
        int[][] matrix = {
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        Test4 test4 = new Test4();
        System.out.println(test4.find(matrix , 7));
        System.out.println(test4.find(matrix , 1));
        System.out.println(test4.find(matrix , 0));
    }

}
