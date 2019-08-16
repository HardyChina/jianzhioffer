package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 比较不同list的性能
 */
public class ListTest {
    @Test
    public void testArrayList(){
        List<Integer> list = new ArrayList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i <100000 ; i++) {
            list.add(0,i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
    @Test
    public void testLinkList(){
        List<Integer> list = new LinkedList<>();
        long start = System.currentTimeMillis();
        for (int i = 0; i <100000 ; i++) {
            list.add(0,i);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
