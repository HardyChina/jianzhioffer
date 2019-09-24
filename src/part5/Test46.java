package part5;

/**
 * 把数字翻译成字符串
 * @author
 */
public class Test46 {
    public static int getTranslationCount(int number){
        if (number < 0){
            return 0;
        }
        String numStr = String.valueOf(number);
        int[] counts = new int[numStr.length()];
        int count = 1;
        for (int i = numStr.length() - 1; i >= 0; i--) {
            if (i < numStr.length() - 1){
                count = counts[i+1];
            }
            if (i < numStr.length() - 1){
                int digit1 = numStr.charAt(i)-'0';
                int digit2 = numStr.charAt(i+1)-'0';
                int conver = digit1*10 + digit2;
                if (conver >= 10 && conver<= 25){
                    if (i < numStr.length() - 2){
                        count += counts[i + 2];
                    }
                    else {
                        count += 1;
                    }

                }
            }
            counts[i] = count;
        }
        return counts[0];
        }

    public static void main(String[] args) {
        System.out.println(getTranslationCount(12258));
    }


    }

