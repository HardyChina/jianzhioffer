package test;

class MyThread extends Thread{
    private String name;
    public MyThread(String name){

        this.name = name;
    }
    @Override
    public void run(){
        System.out.println(name);
        for (int i = 0; i < 20; i++) {
            System.out.println(name+" : "+i);
            //yield();
        }
    }

}