package part5;

/**
 * 最长不含重复字符的子字符串
 * @author 10592
 */
public class Test48 {
    public static int longestSWD(String string){
        int currentLength = 0;
        int maxLength = 0;
        int[] position = new int[26];
        for (int i = 0; i < 26; i++) {
            position[i] = -1;
        }
        for (int i = 0; i < string.length(); i++) {
            int preIndex = position[string.charAt(i)-'a'];
            if (preIndex < 0 || i - preIndex > currentLength){
                currentLength++;
            }
            else {
                if (currentLength > maxLength){
                    maxLength = currentLength;
                }
                currentLength = i - preIndex;

            }
            // 某元素最后出现的位置
            position[string.charAt(i)-'a'] = i;
        }
        // 最后一次可能没有比较
        if (currentLength > maxLength){
            maxLength = currentLength;
        }
        return maxLength;
    }

    public static void main(String[] args) {
        String str = "arabcacfr";
        System.out.println(longestSWD(str));
    }

}
