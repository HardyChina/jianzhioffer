package part3;

/**
 * 正则表达式匹配
 * @author 李震寰
 */
public class Test19 {
    public static boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null){
            return false;
        }
        return matchCore(str,0,pattern,0);
    }
    public  static boolean matchCore(char[] str,int strIndex ,char[] pattern, int pattenIndex){
        if(strIndex == str.length && pattenIndex == pattern.length){
            return true;
        }
        if(strIndex != str.length && pattenIndex == pattern.length){
            return false;
        }
        // *时，不相等则str不变，pat+2；相等时str+1，pat不变或+2，或者str边，pat+2（*代表0个时）不要忽略.*的情况
        if (pattenIndex < pattern.length-1 && pattern[pattenIndex+1] == '*'){
            if ((strIndex != str.length && pattern[pattenIndex] == str[strIndex]) || (pattern[pattenIndex] == '.' && strIndex != str.length)){
                //匹配一个字符
                return matchCore(str,strIndex+1,pattern, pattenIndex+2)
                        //重复字符，一直匹配
                        || matchCore(str, strIndex+1,pattern, pattenIndex)
                        //跳过，匹配0个字符
                        || matchCore(str, strIndex, pattern, pattenIndex+2);
            }
            else {
                return matchCore(str, strIndex, pattern, pattenIndex+2);
            }

        }
        if (( str.length!= strIndex && str[strIndex] == pattern[pattenIndex] )|| (pattern[pattenIndex]=='.' && strIndex != str.length)){
            return matchCore(str, strIndex+1, pattern, pattenIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        char[] str = new String("").toCharArray();
        char[] patten = new String(".*").toCharArray();
        System.out.println(match(str, patten));


    }
}
