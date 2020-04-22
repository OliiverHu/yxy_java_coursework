package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class WPrinter extends Thread implements Printer {
    private BinarySemaphore semW;
    private BinarySemaphore semX;
    private Semaphore semWyz;
    public WPrinter(BinarySemaphore bsem1, BinarySemaphore bsem2, Semaphore sem) {
        this.semW = bsem1;
        this.semX = bsem2;
        this.semWyz = sem;
    }


    @Override
    public void run() {
        while (true)
        {
            try {
                semW.P();
                //Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //semWX.P();

            try {
                int r = (int)(Math.random() * 10);
                Thread.sleep(r);
                //Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            print('W');
            semX.V();
            semWyz.V();
        }
    }

    @Override
    public void print(char c) {
        System.out.print(c);
    }
}
