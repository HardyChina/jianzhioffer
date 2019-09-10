package test.huawei;

import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String[] strs = scanner.nextLine().split(" ");
            int[] array = Arrays.stream(strs).mapToInt(Integer::parseInt).toArray();
            int len = array.length;
            int[] steps = new int[len/2];
            for (int i = 0; i < len/2; i++) {
               steps[i] = go(i,array,i,1);
            }
            int min = Arrays.stream(steps).max().getAsInt();
            if (min == 0){
                System.out.println(-1);
            }
            for (int i = 1; i < steps.length; i++) {
                if (steps[i] < min && steps[i] != -1){
                    min = steps[i];
                }
            }
            System.out.println(min);

        }
    }
    public static int go(int start, int[] array,int index, int step){
        if (index == array.length - 1){
            return  step;
        }
        if (index >= array.length){
            return -1;
        }
        return go(index,array,index+array[index],step+1);

    }
}
