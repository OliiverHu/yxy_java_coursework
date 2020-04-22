package CSC8002AdvancedProgrammingCoursework2.exercise2;

public class slidesExampleTest2 {
    public static class MyThread extends Thread
    {
        public MyThread(String name)
        {
            super(name);
        }
        public void run()
        {
            for (int i=1; i<=10; i++)
            {
                System.out.println("My name is " + getName());
                try
                {
                    sleep(1000);
                }
                catch (InterruptedException e)
                {
                    //Should never arrive here,
                    //because interrupt() is never called.
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Thread t1  = new MyThread("t1");
        Thread t2  = new MyThread("t2");
        t1.start();
        t1.join(); // current thread halts here to wait the end of the t1 thread
        t2.start();
    }
}
