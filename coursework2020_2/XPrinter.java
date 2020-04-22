package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class XPrinter extends Thread implements Printer {
    private BinarySemaphore semW;
    private BinarySemaphore semX;

    public XPrinter(BinarySemaphore bsem1, BinarySemaphore bsem2) {
        this.semW = bsem1;
        this.semX = bsem2;

    }


    @Override
    public void run() {
        while (true)
        {
            try {
                semX.P();
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

            print('X');
            semW.V();
        }
    }

    @Override
    public void print(char c) {
        System.out.print(c);
    }
}
