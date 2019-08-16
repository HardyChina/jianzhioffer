package test.thread;

public class Producer extends Thread {
    private static int index = 0 ;

    private String name ;

    private TicketPool pool ;

    public Producer(String name,TicketPool pool) {
        super();
        this.name = name;
        this.pool = pool ;
    }

    public void run() {
        while(true){
            int n = pool.add(index ++ );
            System.out.println(name + " add : " + n);
        }
    }
}
