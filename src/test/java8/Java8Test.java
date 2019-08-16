package test.java8;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Java8Test {
    @DisplayName("测试lambda表达式")
    @Test
    public void lambdaTest1(){
        //使用lambda表达式和函数式接口Predicate
        List<String> list = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        filter(list,str->((String)str).startsWith("J"));
        filter(list,x->false);
        filter1(list, str->((String)str).startsWith("S"));
        filter2(list);
    }

    /**
     * Java 8中使用lambda表达式的Map和Reduce示例
     */
    @Test
    public void lambdaTest2(){
        // lambda表达式传到 map() 方法，后者将其应用到流中的每一个元素。然后用 forEach() 将列表元素打印出来。
        List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
        costBeforeTax.stream().map((Integer cost) -> cost + .12*cost).forEach(System.out::println);
        //reduce() 函数可以将所有值合并成一个。
        double bill = costBeforeTax.stream().map(cost -> cost + .12* cost).reduce((sum, cost)->sum + cost).get();
        System.out.println(bill);


    }

    @Test
    public  void  lambdaTest3(){
        List<Integer> list = Arrays.asList(1,2,2,2,2,5,5,8,8);
        IntSummaryStatistics intSummaryStatistics = list.stream().mapToInt(x->x+1).summaryStatistics();
        //求最大值
        System.out.println("max is "+intSummaryStatistics.getMax());
        //最小值
        System.out.println("min is "+intSummaryStatistics.getMin());
        //求平均值
        System.out.println("avg is "+intSummaryStatistics.getAverage());
        //去重复
        List<Integer> list1 = list.stream().distinct().collect(Collectors.toList());
        list1.forEach(System.out::print);

}
    

    public static void filter(List<String> names, Predicate predicate){
        for(String name : names){
            if(predicate.test(name)){
                System.out.println(name);
            }
        }
    }
    //相比filter更好的写法
    public static void filter1(List<String> names , Predicate predicate){
        names.stream().filter((name)->(predicate.test(name))).forEach(System.out::println);
    }
    //通过predicate的and(),or()合并条件
    public static void filter2(List<String> names){
        Predicate startWithJ = str -> ((String)str).startsWith("J");
        Predicate startWithS = str -> ((String)str).startsWith("S");
        //合并两个条件
        names.stream().filter((name)->(startWithJ.and(startWithS).test(name))).forEach(System.out::println);
    }
}
