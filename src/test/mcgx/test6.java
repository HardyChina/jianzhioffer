package test.mcgx;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class test6 {
    @Test
    public void hashTest(){
        String str = new String("hash");
        System.out.println(str.hashCode());
        System.out.println(Objects.hashCode(str));
        System.out.println(Objects.deepEquals(str,"hash"));

    }
    @Test
    public void classlosdTest(){
        //系统类加载器测试
        String string = new String("hash");
        System.out.println(string.getClass().getClassLoader());
        //自定义类的加载器测试
        class Inno{};
        Inno a = new Inno();
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a.getClass().getClassLoader().getParent());
    }
    @Test
    public void iteratorTest(){
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");
        //Iterator的两种遍历方式
        System.out.println("for循环遍历");
        for (Iterator<String> iterator = list.iterator();iterator.hasNext();){
            //使用迭代器迭代时会进行数量比较，所以不能在集合中使用add方法添加
           //list.add("tsst");
            System.out.println(iterator.next());
        }

        System.out.println("while循环遍历");
        Iterator<String> whileIterator = list.iterator();
        while (whileIterator.hasNext()){
            System.out.println(whileIterator.next());
        }

        System.out.println("使用listIterator");
        ListIterator<String> listIterator = list.listIterator(list.size());
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }

    }
    @Test
    public void array2listTest(){
        List<String> list = new ArrayList<>();
        list.add("first");
        list.add("second");
        list.add("third");
        list.add("fourth");

        String[] array = {"first","second","third","fourth"};

        //数组转集合
        List<String> array2List = Arrays.asList(array);
        System.out.println(array2List.getClass());
        List<String> array2RealList = new ArrayList<>(array2List);
        System.out.println(array2RealList.getClass());
        Iterator<String> iterator = array2List.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //集合转数组
        String[] list2String = new String[list.size()];
        // 使用无参数的toArray会造成泛型丢失
        Arrays.stream(list.toArray()).forEach(System.out::println);
        list.toArray(list2String);
       // String[] list2String2  = (String[]) list.toArray();



    }
    @Test
    public void cowTest(){
        List<Integer> copy = new CopyOnWriteArrayList<>();

        long start = System.nanoTime();
        for (int i = 0; i <20*10000 ; i++) {
            copy.add(i);
        }
        long end = System.nanoTime();
        System.out.println(end-start);
    }
    @Test
    public void treeMapTest(){
        Map<Integer,String> treeMap = new TreeMap<>();
        treeMap.put(1,"one");
        treeMap.put(3,"three");
        treeMap.put(2,"two");
        System.out.println(treeMap.entrySet());
    }
    @Test
    public void arrayTest(){
        String[] strings = {"a","b"};
        System.out.println(strings);
        Object obj = strings;
        System.out.println(((String[])obj)[0]);
    }

}
