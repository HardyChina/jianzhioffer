package test.mcgx;

import org.junit.Test;

import java.util.concurrent.*;

public class test7 {

    private static  volatile long count = 0L;
    private static final int NUMBER = 10000;

    @Test
    /**
     * 测试volatile的非原子性
     */
    public void volatileTest(){
       Runnable suntractThread = new Thread(){
           @Override
           public void run(){
               for (int i = 0; i <NUMBER ; i++) {
                   count--;
               }
           }
       };
       ((Thread) suntractThread).start();
        for (int i = 0; i <NUMBER ; i++) {
            count++;
        }
        while (((Thread) suntractThread).isAlive()){ }
        System.out.println("count最后的值为"+count);
    }
    /**
     * callable测试
     */
    @Test
    public void callableTest(){
         class CallableTest implements Callable<String>{

             /**
              * Computes a result, or throws an exception if unable to do so.
              *
              * @return computed result
              * @throws Exception if unable to compute a result
              */
             @Override
             public String call() throws Exception {
                 return "Hello world";
             }
         }
         //创建线程池
         ExecutorService executorService = Executors.newSingleThreadExecutor();
         Future feature = executorService.submit(new CallableTest());
        System.out.println("wait thread to finish");
        try {
            System.out.println(feature.get());

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 信号量同步测试
     */
    @Test
    public void countDownTest() throws InterruptedException {
        class ThreadTest extends Thread{
            private String context;
            private  final  CountDownLatch count;
            public ThreadTest(String context,CountDownLatch count){
                this.context = context;
                this.count =count;
            }
           @Override
            public void run(){
                if(Math.random() > 0.5){
                    throw new RuntimeException("error");
                }
               System.out.println(context+"over");
                //由于之前抛出异常而没有执行countDown()方法，导致无法退出。可以把countDown写在finally中
                count.countDown();
           }
           }
           CountDownLatch countDownLatch = new CountDownLatch(3);
        //三个线程通过一个CountDownLatch控制
        Thread thread1 = new ThreadTest("1st",countDownLatch);
        Thread thread2 = new ThreadTest("2nd",countDownLatch);
        Thread thread3 = new ThreadTest("3rd",countDownLatch);


        thread1.start();
        thread2.start();
        thread3.start();

        //等待十秒，十秒后终止线程
        countDownLatch.await(10,TimeUnit.SECONDS);
        System.out.println("all over");
    }
    @Test
    public void semaphoreTest(){
        class SemaphoreTest extends Thread{
            private final Semaphore semaphore;
            private int seq;
            public SemaphoreTest(int seq,Semaphore semaphore){
                this.seq = seq;
                this.semaphore = semaphore;
            }
            @Override
            public  void  run(){
                try{
                    semaphore.acquire();
                    System.out.println(seq+"乘客正在检票");
                    if (seq % 2 == 0) {
                        Thread.sleep(1000);
                        System.out.println(seq+"乘客可疑，接收进一步安检。");
                    }
                }
                catch (Exception e){e.printStackTrace();}
                finally {
                    semaphore.release();
                    System.out.println(seq+"乘客已经完成服务。");
                }
            }
        }
        Semaphore semaphore = new Semaphore(3);

        for (int i = 1; i <= 5 ; i++) {
            new SemaphoreTest(i,semaphore).start();
        }
    }
    @Test
    public void threadLocalTest(){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        ExecutorService pool = Executors.newFixedThreadPool(1);

        class ThreadLocalTest extends Thread{
            private  boolean flag = true;
            @Override
            public void run(){
                //第一个线程set后第二个没有执行set,第一个set后没有执行remove()
                if (flag) {
                    threadLocal.set(this.getName());
                    flag = false;
                }
                System.out.println(this.getName()+"线程是"+threadLocal.get());
            }
        }
        for (int i = 0; i < 2 ; i++) {
            pool.execute(new ThreadLocalTest());

        }
    }
}
