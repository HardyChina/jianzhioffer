package part5;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author 10592
 */
public class Test50 {
    /**
     * 字符串中第一个只出现一次的字符
     * @param str
     * @return
     */
    public static int FirstNotRepeatingChar(String str) {
        if ("".equals(str)|| str == null){
            return -1;
        }
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length() ; i++) {
            String key = String.valueOf(str.charAt(i));
            if (map.containsKey(key)){
                map.put(key,map.get(key)+1);
            }else {
                map.put(key,1);
            }
        }
        int i;
        for ( i = 0; i < str.length(); i++) {
            if (map.get(String.valueOf(str.charAt(i)))==1){
                break;
            }
        }
        return i;
    }
    LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
    //字符流中第一次只出现一次的字符
    //Insert one char from stringstream
    public void Insert(char ch) {
        int ascii = ch;
        if (map.containsKey(ascii)){
            map.put(ascii,map.get(ascii)+1);
        } else {
          map.put(ascii,1);
        }

    }
    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce()
    {
        for (Map.Entry<Integer,Integer> e :
                map.entrySet()) {
            if (e.getValue()==1){
                int ascii = e.getKey();
                return (char) ascii;
            }
        }
        return '#';

    }

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("abcdea"));
    }
}
