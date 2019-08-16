package test.thread;

public class App {
    public static void main(String[] args) {

        TicketPool pool = new TicketPool();
        Producer p1 = new Producer("P1", pool);
        Producer p2 = new Producer("P2", pool);
        Customer c1 = new Customer("C1", pool);

        p1.start();
        p2.start();
        c1.start();
    }
}
