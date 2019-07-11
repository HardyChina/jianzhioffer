package part2;

/**
 * 替换空格
 * @author 李震寰
 */
public class Test5 {
    /**
     * 将空格替换为20%
     * @param str
     * @return
     */
    public static String replaceBlank(StringBuilder str){
        if (str == null|| str.equals("")){
            return null;
        }
        int oldIndex = str.length();
        int blankNum = 0;
        int newIndex = 0;
        //获取空格数
        for (int i = 0; i < oldIndex; i++) {
            if (str.charAt(i)== ' '){
                blankNum++;
            }
        }
        newIndex = oldIndex + blankNum*2;
        str.setLength(newIndex);
        newIndex--;
        oldIndex--;
        while(oldIndex>=0&& newIndex>=oldIndex){
            if (str.charAt(oldIndex)== ' '){
                str.setCharAt(newIndex--,'0');
                str.setCharAt(newIndex--,'2');
                str.setCharAt(newIndex--,'%');
                oldIndex--;
            }
            else {
                str.setCharAt(newIndex--, str.charAt(oldIndex--));
            }
        }
        return str.toString();

    }
    public static void main(String[] args){
        System.out.println(replaceBlank(new StringBuilder("Hello World")));
    }
}
