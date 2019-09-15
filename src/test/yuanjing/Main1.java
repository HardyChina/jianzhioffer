package test.yuanjing;

/**
 * @author 10592
 */
import java.util.Arrays;
import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inputString = "";
        if (sc.hasNextLine()) {
            inputString = sc.nextLine();
        }
        String[] inputArrayInt = inputString.split(" ");
        int len = inputArrayInt.length;
        int[] intArray = new int[len];
        for (int i = 0; i < len; i++) {
            intArray[i] = Integer.valueOf(inputArrayInt[i]);
        }
        System.out.println(maxProfit(intArray));
    }

    public static int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return Math.abs(maxprofit);
    }




}
