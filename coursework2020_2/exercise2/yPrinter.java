package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class yPrinter extends Thread implements Printer {
    private Semaphore semWyz;
    private BinarySemaphore semy;
    private BinarySemaphore semz;

    public yPrinter(BinarySemaphore bsem1, BinarySemaphore bsem2, Semaphore sem) {
        this.semy = bsem1;
        this.semz = bsem2;
        this.semWyz = sem;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                //this.semyz.P();
                this.semWyz.P();
                //Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                //this.semWyz.P();
                semy.P();
                //Thread.sleep(50);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                int r = (int)(Math.random() * 10);
                Thread.sleep(r);
                //Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            print('y');
            semz.V();
        }
    }

    @Override
    public synchronized void print(char c) {
        System.out.print(c);
    }
}
