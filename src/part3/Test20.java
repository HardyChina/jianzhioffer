package part3;



/**
 * 表示数字的字符串
 * @author 李震寰
 */
public class Test20 {
   static int index = 0;
    public static boolean isNumeric(char[] str) {
        if (str == null){
            return false;
        }
        boolean numeric = scanInteger(str);
        if (index < str.length && str[index] == '.'){
            index++;
            numeric = scanUInteger(str) || numeric;
        }
        if (index < str.length && (str[index] == 'E' || str[index] == 'e')){
            index++;
           numeric = numeric&& scanInteger(str);
        }
        return numeric && index == str.length;

    }
   static boolean scanInteger(char[] str){
        if (index < str.length && (str[index] == '+' || str[index] == '-')) {
            index++;
        }
        return scanUInteger(str);
    }
   static boolean scanUInteger(char[] str){
        int before = index;
        while (index < str.length && str[index] >= '0'&& str[index] <= '9'){
                index++;
            }
        return before < index;


    }

    /**
     * 使用正则表达式解决
     * @param str
     * @return
     */
    public static boolean isNumericByReg(char[] str) {
        String patten = "[+-]?[0-9]*(\\.[0-9)*])?([eE]?[0-9]+)?";
        return new String(str).matches(patten);
    }
    public static void main(String[] args) {
        char[] str = new String("100").toCharArray();
        System.out.println(isNumeric(str));
        System.out.println(isNumericByReg(str));

    }
}
