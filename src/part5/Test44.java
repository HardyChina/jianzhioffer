package part5;

/**
 * 数字序列中某一位的数字
 * @author 10592
 */
public class Test44 {
    public int  digitAtIndex(int index){
        if (index < 0){
            return -1;
        }
        int digit = 1;
        while (true){
            // digit位数字共有多少个
            int number = countOfIntegers(digit);
            //  number*digit表示digit位数字共有多少个数字字符
            if (index < number*digit){
                return digitAtIndex(index,digit);
            }
            index -= number*digit;
            digit++;
        }

    }

    /**
     *
     * @param digit
     * @return
     */
    private int countOfIntegers(int digit){
        if (digit == 1){
            return 10;
        }
        return 9*(int) Math.pow(10,digit - 1);

    }
    private int digitAtIndex(int index, int digit){
        // 要找的字符所在的数字
        int num = beginOfDigit(digit) + index/digit;
        int indexFromRight = digit - index % digit;
        for (int i = 1; i < indexFromRight; i++) {
            num /= 10;
        }
        return num % 10;

    }
    private int beginOfDigit(int digit){
        if (digit == 1){
            return 0;
        }
        return (int) Math.pow(10,digit-1);

    }

    public static void main(String[] args) {
        Test44 test = new Test44();
        System.out.println(test.digitAtIndex(1001));
        System.out.println(test.digitAtIndex(5));
        System.out.println(test.digitAtIndex(13));
    }


}
