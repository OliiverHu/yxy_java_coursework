package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class mainThread {
    public static void main(String[] args) throws InterruptedException
    {
        BinarySemaphore semW = new BinarySemaphore(1);
        BinarySemaphore semX = new BinarySemaphore(0);

        BinarySemaphore semy = new BinarySemaphore(1);
        BinarySemaphore semz = new BinarySemaphore(0);

        Semaphore semWyz = new Semaphore(0);

        Thread W = new WPrinter(semW, semX, semWyz);
        Thread X = new XPrinter(semW, semX);
        Thread y = new yPrinter(semy, semz, semWyz);
        Thread z = new zPrinter(semy, semz, semWyz);


        //while (true) {
        W.start();
        X.start();
        y.start();
        z.start();

        //int r = (int)(Math.random() * 10);
        Thread.sleep(555);


        System.exit(0);
    }
}
