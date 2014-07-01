package name.samolisov.demo.spring.workmanager.services.task;

public class HelloWorldTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Hello World from " + Thread.currentThread().getName());
        sleep();
    }

    private static void sleep() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
