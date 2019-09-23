package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        boolean flag = false;
        int num;
        while(sc.hasNext()){
            try{
                num = sc.nextInt();
            }catch (Exception e){

                continue;
            }

            int[] nums = split(num);
            int mid = nums.length/2;
            int index = 0;
            int a = 1;
            int b = 1;

            while(mid < nums.length && mid > 0){
                while(index < mid ){
                    a *= nums[index++];
                }
                while(index < nums.length){
                    b *= nums[index++];
                }
                if(a==b){
                    System.out.println("YES");
                    flag = true;
                    break;
                }
                else if(a > b){
                    mid --;
                }
                else{
                    mid++;
                }
            }
            if (!flag) {
                System.out.println("NO");
            }
        }
    }
    public static int[] split(int num){
        ArrayList<Integer> list = new ArrayList<>();
        while(num > 0){
            list.add(num%10);
            num /= 10;
        }
        Integer[] nums = new Integer[list.size()];
        list.toArray(nums);
        return Arrays.stream(nums).mapToInt(x->x).toArray();
    }


}
