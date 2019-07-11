package part2;

/**
 * @author 李震寰
 * 实现一个单例模式
 */
public class Test2 {
    /**
     * 只适用于单线程环境的单例模式，不推荐
     */
    public static class Singleton1{
        private Singleton1(){
            System.out.println("This is Singleton1");
        }
        //初始情况下默认
        private static Singleton1 instance = null;
        public static Singleton1 getInstance(){
            if (instance == null){
                instance = new Singleton1();
            }
            return instance;
        }
    }
    /**
     * 通过加锁实现多线程单例模式
     */
    public static class Singleton2{
        private Singleton2(){
            System.out.println("This is Singleton2");
        }
        private static Singleton2 instance = null;
        private static Object object  = new Object();
        /**
         *   通过使用synchronized关键字实现多线程单例模式
         */
        public static  Singleton2 getInstance(){
            //锁会消耗资源提前使用判断可以减少锁的使用
            if (instance == null) {
                synchronized (object) {
                    if (instance == null) {
                        instance = new Singleton2();
                    }
                }
            }
            return instance;
        }
    }
    /**
     * 通过静态类实现单例模式，缺点是无法控制加载时机
     */
    public static class Singleton3{
        private Singleton3(){
            System.out.println("This is Singleton3");
        }
        private static final Singleton3 instance = new Singleton3();

        private static Singleton3 getInstance(){
            return instance;
        }
    }

    /**
     * 通过静态内部类实现单例模式，可以控制加载时机【推荐】
     */
    public static class Singleton4{
        private Singleton4(){
            System.out.println("This is Singleton4");
        }
        private final static class SingletonHolder{
            private final static Singleton4 instance = new Singleton4();
        }
        public static Singleton4 getInstance(){
            return  SingletonHolder.instance;
        }

    }
    public static void main(String[] args){
        Singleton1.getInstance();
        Singleton1.getInstance();
        Singleton2.getInstance();
        Singleton2.getInstance();
        Singleton3.getInstance();
        Singleton3.getInstance();
        Singleton4.getInstance();
        Singleton4.getInstance();
    }

}
