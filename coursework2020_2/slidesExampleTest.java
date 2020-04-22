package CSC8002AdvancedProgrammingCoursework2.exercise2;



public class slidesExampleTest {
    public static class CountingThread extends Thread
    {
        private static final int MAX = 100;
        private Counter myCounter;
        public CountingThread(Counter c)
        {
            myCounter = c;
        }
        public void run()
        {
            for (int i=0; i<MAX; i++) {
                myCounter.increment();
                //System.out.println(getName() + ": " + myCounter.value);
                //notify();
//                try {
//                    Thread.sleep(50);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }
    }

    public static class Counter
    {
        private int value;
        public Counter()
        {
            value = 0;
        }
        public void increment()
        {
            value = value + 1;
            System.out.println(value);
        }
    }


    public static void main(String[] args)
    {
        Counter counter = new Counter();
        Thread thread1 = new CountingThread(counter);
        Thread thread2 = new CountingThread(counter);
        thread1.start();
        thread2.start();
    }
}
