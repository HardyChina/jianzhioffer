package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class UtilTest {

    @Test
    /**
     * 不使用中间变量交换值
     */
    public void exchange(){
        int a = 3;
        int b = 2;
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println(a+"  "+ b);
    }

    /**
     * String是不可变对象
     * StringBuilder为可变对象且线程不安全
     * StringBuffer是StringBuilding的线程安全版本，两个类实现了相同的接口和抽象类。
     */
    public void stringTest(){
        String string = "String";
        StringBuffer stringBuffer = new StringBuffer(string);
        StringBuilder stringBuilder = new StringBuilder(string);
        stringBuilder.setLength(6);
        stringBuffer.setLength(6);

    }
    @Test
    public void IntegerTest(){
        int n = 10;
        // toBinaryString()返回一个二进制字符串。
        char[] ch = Integer.toBinaryString(n).toCharArray();
        System.out.println(ch);
    }

    @Test
    /**
     * 测试double的精度问题
     */
    public void doubleTest(){
        double a1 = 0.9;
        double a2 = 0.9;
        //精度问题，因此比较两个浮点数的值不能用if(num1 == num2)
        System.out.println(a1-0.1-0.1);
        System.out.println(a2 - 0.2);
        System.out.println((a1 - 0.1 - 0.1) == (a2 - 0.2));
        System.out.println(a1);

    }
        @Test
        /**
         * 正则表达式测试
         */
        public void rexTest() {
            String[] strs = {"123","1a3.14","???","aaa??","exe.exe"};
            // String pattern = "^[a-zA-Z0-9\\u4e00-\\u9fa5]+$";
            String pattern = "^[0-9]+$";

            Pattern r = Pattern.compile(pattern);
            for (String str:
                 strs) {
                Matcher m = r.matcher(str);
                System.out.println(m.matches());
            }

        }
        @Test
    public void indexTest(){
            int[] push = {1,2,3,4,5};
             int index = Arrays.stream(push).boxed().collect(Collectors.toList()).indexOf(4);
            System.out.println(index);
        }


}
