package part2;

/**
 * 矩形覆盖，牛客网上的第十题
 */
public class Test10 {
    public int RectCover(int target) {
        int result[] = {0, 1, 2};
        if (target <= 0){
            return result[0];
        }
        if (target < 3){
            return result[target];
        }
        int one = 2;
        int two = 1;
        int n = 0;
        for (int i = 3; i <= target ; i++) {
            n = one + two;
            two = one;
            one = n;
        }
        return n;
    }
}
