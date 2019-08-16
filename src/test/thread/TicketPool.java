package test.thread;

import java.util.LinkedList;
import java.util.List;

public class TicketPool {
    List<Integer> pool = new LinkedList<>();
    public static final int MAX_NUM = 100;
    public synchronized int add(Integer i) {
        while (pool.size()>=MAX_NUM) {
            try {
               // notify();
                wait(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        pool.add(i);
        notify();
       return i;
    }
    public synchronized int remove(){
        while(pool.isEmpty()){
            try {
                notify();
                wait(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int n = pool.remove(0);
        notify();
        return n;
    }
}
