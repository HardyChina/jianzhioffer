package test.mcgx;

import java.util.concurrent.*;

/**
 * 阿里一面的题
 * 实现一个类，顺序执行十个线程并打印n，全部打印完成后在输出打印完成，
 * @author lzh
 *
 */
public class CyclicBarrierTest {
    public static volatile int n = 0;

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicThread[] thread = new CyclicThread[10];
        for (int i = 0; i < thread.length; i++) {
            thread[i] = new CyclicThread(n++,cyclicBarrier);
//            thread[i].start();
            executorService.execute(thread[i]);
        }
        executorService.shutdown();



    }
    private static class CyclicThread extends Thread{
        private int n;
        private CyclicBarrier cyclicBarrier;
        public CyclicThread(int n, CyclicBarrier cyclicBarrier){
            this.n = n;
            this.cyclicBarrier = cyclicBarrier;
        }
        @Override
        public void run(){
            System.out.println(n);
            try {
                cyclicBarrier.await(10L,TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
            System.out.println("输出完成");
        }

    }

}
