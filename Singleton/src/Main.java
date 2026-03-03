public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            Singleton singleton1 = Singleton.getInstance();
            System.out.println("Singleton Instance 1: " + singleton1.hashCode() + "from Thread 1");
        });
        Thread t2 = new Thread(() -> {
            Singleton singleton2 = Singleton.getInstance();
            System.out.println("Singleton Instance 2: " + singleton2.hashCode() + "from Thread 2");
        });
        Thread t3 = new Thread(() -> {
            Singleton singleton3 = Singleton.getInstance();
            System.out.println("Singleton Instance 3: " + singleton3.hashCode() + "from Thread 3");
        });
        Thread t4 = new Thread(() -> {
            Singleton singleton4 = Singleton.getInstance();
            System.out.println("Singleton Instance 4: " + singleton4.hashCode() + "from Thread 4");
        });
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}