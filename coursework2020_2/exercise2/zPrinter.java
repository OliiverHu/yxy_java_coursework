package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class zPrinter extends Thread implements Printer {
    private Semaphore semWyz;
    private BinarySemaphore semy;
    private BinarySemaphore semz;

    public zPrinter(BinarySemaphore bsem1, BinarySemaphore bsem2, Semaphore sem) {
        this.semy = bsem1;
        this.semz = bsem2;
        this.semWyz = sem;
    }

    @Override
    public void run() {
        while (true)
        {
            try {
                this.semWyz.P();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            try {
                this.semz.P();
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

            print('z');
            this.semy.V();
//            try {
//                this.semy.V();
//                //Thread.sleep(50);
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            //System.out.print('z');
        }
    }

    @Override
    public synchronized void print(char c) {
        System.out.print(c);
    }
}
