package part5;

/**
 * 整数中1出现的次数（从1到n整数中1出现的次数）
 * @author 10592
 */
public class Test43 {
    public int NumberOf1Between1AndN_Solution(int n) {
        if(n <= 0){
            return 0;
        }
        int count = 0;
        for (int i = 1; i <= n; i=i*10) {
            //k = n % (i * 10)
            //count(i) = (n / (i * 10)) * i + (if(k > i * 2 - 1) i else if(k < i) 0 else k - i + 1)
            long diviver = i * 10;
            count += (n / diviver)*i + Math.min(Math.max(n%diviver - i +1, 0),i);
        }
        return count;

        }
    }

